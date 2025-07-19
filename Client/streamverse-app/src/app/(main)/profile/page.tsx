"use client";

import { useState, useEffect } from "react";
import { useRouter } from "next/navigation";
import { useAuth } from "@/lib/AuthContext";
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
import { toast } from "sonner";
import { Alert, AlertDescription, AlertTitle } from "@/components/ui/alert";
import LoadingSpinner from "@/components/ui/loading-spinner";

// TODO: Fetch user data from /api/auth/me and replace this dummy data
const dummyUser = {
  username: "dian",
  email: "dian@example.com",
  profilePicture: "https://github.com/shadcn.png",
};

export default function ProfilePage() {
  const router = useRouter();
  const { isAuthenticated } = useAuth();
  const [username, setUsername] = useState(dummyUser.username);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    if (!isAuthenticated) {
      toast.error("You must be logged in to view this page.");
      const timer = setTimeout(() => {
        router.push("/login");
      }, 2000);
      return () => clearTimeout(timer);
    }
  }, [isAuthenticated, router]);

  const handleSaveChanges = async () => {
    setIsLoading(true);
    setError(null);

    // TODO: Implement API call to PATCH /api/auth/me
    console.log("Saving changes for username:", username);

    // Simulate API call
    await new Promise((resolve) => setTimeout(resolve, 1000));

    // Example success/error handling
    const success = Math.random() > 0.3; // Simulate success/failure
    if (success) {
      toast.success("Your profile has been updated.");
      // TODO: Update user data in AuthContext
    } else {
      setError("Failed to update profile. Please try again.");
    }

    setIsLoading(false);
  };

  if (!isAuthenticated) {
    return (
      <div className="flex flex-col justify-center items-center h-screen">
        <LoadingSpinner width={128} height={128} />
        <p className="mt-4 text-muted-foreground text-4xl">
          Redirecting to login...
        </p>
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
                src={dummyUser.profilePicture}
                alt={`@${dummyUser.username}`}
              />
              <AvatarFallback>
                {dummyUser.username.charAt(0).toUpperCase()}
              </AvatarFallback>
            </Avatar>
          </div>
          {error && (
            <Alert variant="destructive">
              <AlertTitle>Error</AlertTitle>
              <AlertDescription>{error}</AlertDescription>
            </Alert>
          )}
          <div className="space-y-2">
            <Label htmlFor="username">Username</Label>
            <Input
              id="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>
          <div className="space-y-2">
            <Label htmlFor="email">Email</Label>
            <Input id="email" value={dummyUser.email} readOnly disabled />
          </div>
        </CardContent>
        <CardFooter>
          <Button
            onClick={handleSaveChanges}
            disabled={isLoading || username === dummyUser.username}
          >
            {isLoading ? "Saving..." : "Save Changes"}
          </Button>
        </CardFooter>
      </Card>
    </div>
  );
}
