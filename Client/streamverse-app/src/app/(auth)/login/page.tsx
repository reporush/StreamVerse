"use client";

import { useState, useEffect } from "react";
import { useAuth } from "@/lib/AuthContext"; // 1. Import your useAuth hook

import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { AuthCard } from "@/components/auth/AuthCard";
import { GoogleButton } from "@/components/auth/GoogleButton";
import { SubmitButton } from "@/components/auth/SubmitButton";
import { Alert, AlertDescription, AlertTitle } from "@/components/ui/alert";
import { useRouter } from "next/navigation";
import LoadingSpinner from "@/components/ui/loading-spinner";

export default function LoginPage() {
  const { login, isAuthenticated, loading } = useAuth();
  const router = useRouter();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    if (!loading && isAuthenticated) {
      router.push("/");
    }
  }, [isAuthenticated, loading, router]);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    try {
      await login(username, password);
      window.location.href = "/";
    } catch (err) {
      setError("Invalid username or password. Please try again.");
    }
  };

  if (loading || isAuthenticated) {
    return (
      <div className="flex h-screen items-center justify-center">
        <LoadingSpinner width={64} height={64} />
      </div>
    );
  }

  return (
    <AuthCard
      title="Login"
      description="Welcome back! Please enter your details."
      footerText="Don't have an account?"
      footerLink="/register"
      footerLinkText="Register"
    >
      <form className="grid gap-4" onSubmit={handleSubmit}>
        {error && (
          <Alert variant="destructive">
            <AlertTitle>Login Failed</AlertTitle>
            <AlertDescription>{error}</AlertDescription>
          </Alert>
        )}
        <div className="grid gap-2">
          <Label htmlFor="email" className="text-muted-foreground">
            Username
          </Label>
          <Input
            id="username"
            name="username"
            type="text"
            placeholder="john_doe"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div className="grid gap-2">
          <Label htmlFor="password" className="text-muted-foreground">
            Password
          </Label>
          <Input
            id="password"
            name="password"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <SubmitButton className="w-full">Login</SubmitButton>
        <GoogleButton />
      </form>
    </AuthCard>
  );
}
