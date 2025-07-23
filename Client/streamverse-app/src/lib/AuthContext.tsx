"use client";

import React, {
  createContext,
  useContext,
  useState,
  ReactNode,
  useEffect,
} from "react";
import { useRouter } from "next/navigation";
import { toast } from "sonner";
import axios from "axios";

axios.defaults.withCredentials = true;

interface User {
  username: string;
  email: string;
  role: "STREAMER" | "USER";
  displayName: string;
  profileImageUrl: string;
}

interface AuthContextType {
  user: User | null;
  isAuthenticated: boolean;
  loading: boolean;
  login: (username: string, password: string) => void;
  logout: () => void;
  updateUser: (data: Partial<User>) => void;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider = ({ children }: { children: ReactNode }) => {
  const router = useRouter();
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState(true);

  const isAuthenticated = !!user;

  const updateUser = (data: Partial<User>) => {
    setUser((prevUser) => (prevUser ? { ...prevUser, ...data } : null));
  };

  useEffect(() => {
    const responseInterceptor = axios.interceptors.response.use(
      (response) => response,
      (error) => {
        if (error.response && error.response.status === 401) {
          console.log("Session expired or invalid, logging out.");
          // Only logout if a user was previously set
          if (user) {
            logout();
          }
        }
        return Promise.reject(error);
      },
    );

    return () => {
      axios.interceptors.response.eject(responseInterceptor);
    };
  }, [user]); // Rerun if user changes

  useEffect(() => {
    const checkUserSession = async () => {
      try {
        const response = await axios.get("http://localhost:6969/api/users/me");
        setUser(response.data);
      } catch (error) {
        console.log("No active session found.");
        setUser(null);
      } finally {
        setLoading(false);
      }
    };

    checkUserSession();
  }, []);

  const login = async (username: string, password: string) => {
    try {
      const response = await axios.post(
        "http://localhost:6969/api/auth/login",
        { username, password },
      );
      setUser(response.data.user);
    } catch (error) {
      console.error("Login failed:", error);
      throw error;
    }
  };

  const logout = async () => {
    try {
      await axios.post("http://localhost:6969/api/auth/logout");
      toast.success("You have been logged out.");
    } catch (error) {
      console.error("Logout API call failed:", error);
      toast.error("Logout failed. Please try again.");
    } finally {
      setUser(null);
      router.push("/login");
    }
  };

  return (
    <AuthContext.Provider
      value={{ user, isAuthenticated, loading, login, logout, updateUser }}
    >
      {!loading && children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error("useAuth must be used within an AuthProvider");
  }
  return context;
};
