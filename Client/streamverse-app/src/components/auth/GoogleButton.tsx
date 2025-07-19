"use client";

import { useState } from "react";
import { Button } from "@/components/ui/button";
import { Globe, Loader2 } from "lucide-react";

export function GoogleButton() {
  const [isLoading, setIsLoading] = useState(false);

  const handleGoogleSignIn = () => {
    setIsLoading(true);
    // TODO: Implement Google OAuth
    console.log("Signing in with Google");
    setIsLoading(false);
  };

  return (
    <Button
      variant="outline"
      className="w-full"
      onClick={handleGoogleSignIn}
      disabled={isLoading}
    >
      {isLoading ? (
        <Loader2 className="mr-2 h-4 w-4 animate-spin" />
      ) : (
        <Globe className="mr-2 h-4 w-4" />
      )}
      Sign in with Google
    </Button>
  );
}
