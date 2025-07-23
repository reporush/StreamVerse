"use client";

import { useState, useEffect } from "react";
import { useRouter } from "next/navigation";
import { useAuth } from "@/lib/AuthContext";
import axios from "axios";
import { toast } from "sonner";

import { Button } from "@/components/ui/button";
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { Alert, AlertDescription, AlertTitle } from "@/components/ui/alert";
import LoadingSpinner from "@/components/ui/loading-spinner";

export default function ProfilePage() {
  const router = useRouter();
  // Get user and the new updateUser function from context
  const { user, loading, updateUser } = useAuth();

  const [displayName, setDisplayName] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    // Wait until the initial loading is done
    if (!loading && !user) {
      router.push("/login");
    }
    if (user) {
      setDisplayName(user.displayName);
    }
  }, [user, loading, router]);

  const handleSaveChanges = async () => {
    setIsLoading(true);
    setError(null);
    try {
      // API call to update the user profile
      // TODO
      // const response = await axios.put("http://localhost:6969/api/users/me", {
      //   displayName: displayName,
      // });
      // Update the global user state with the returned data
      // updateUser(response.data);
      toast.success("Your profile has been updated.");
    } catch (err) {
      setError("Failed to update profile. Please try again.");
    } finally {
      setIsLoading(false);
    }
  };

  // Display a loading screen while checking for a session
  if (loading || !user) {
    return (
      <div className="flex flex-col justify-center items-center h-full">
        <LoadingSpinner width={128} height={128} />
      </div>
    );
  }

  return (
    <div className="flex justify-center items-center h-full">
      <Card className="w-full max-w-md">
        <CardHeader>
          <CardTitle>My Profile</CardTitle>
          <CardDescription>
            Update your profile information here.
          </CardDescription>
        </CardHeader>
        <CardContent className="space-y-6">
          <div className="flex justify-center">
            <Avatar className="h-24 w-24">
              <AvatarImage
                src={user.profileImageUrl}
                alt={`@${user.username}`}
              />
              <AvatarFallback>
                {user.username.charAt(0).toUpperCase()}
              </AvatarFallback>
            </Avatar>
          </div>
          {error && (
            <Alert variant="destructive">
              <AlertTitle>Error</AlertTitle>
              <AlertDescription>{error}</AlertDescription>
            </Alert>
          )}

          {/* Display Name (Editable) */}
          <div className="space-y-2">
            <Label htmlFor="displayName">Display Name</Label>
            <Input
              id="displayName"
              value={displayName}
              onChange={(e) => setDisplayName(e.target.value)}
            />
          </div>

          <div className="space-y-2">
            <Label htmlFor="username">Username</Label>
            <Input id="username" value={user.username} readOnly disabled />
          </div>

          <div className="space-y-2">
            <Label htmlFor="email">Email</Label>
            <Input id="email" value={user.email} readOnly disabled />
          </div>

          <div className="space-y-2">
            <Label htmlFor="role">Role</Label>
            <Input id="role" value={user.role} readOnly disabled />
          </div>
        </CardContent>
        <CardFooter>
          <Button
            onClick={handleSaveChanges}
            disabled={isLoading || displayName === user.displayName}
          >
            {isLoading ? "Saving..." : "Save Changes"}
          </Button>
        </CardFooter>
      </Card>
    </div>
  );
}
