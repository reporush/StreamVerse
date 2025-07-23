"use client";

import { useActionState, useEffect } from "react";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { AuthCard } from "@/components/auth/AuthCard";
import { GoogleButton } from "@/components/auth/GoogleButton";
import { register, FormState } from "@/lib/actions";
import { SubmitButton } from "@/components/auth/SubmitButton";
import { Alert, AlertDescription, AlertTitle } from "@/components/ui/alert";
import { toast } from "sonner";
import { useRouter } from "next/navigation";
import { useAuth } from "@/lib/AuthContext";
import LoadingSpinner from "@/components/ui/loading-spinner";

const initialState: FormState = {
  success: false,
  message: "",
  errors: {},
};

export default function RegisterPage() {
  const [state, formAction] = useActionState(register, initialState);
  const router = useRouter();
  const { isAuthenticated, loading } = useAuth();

  useEffect(() => {
    if (state.success) {
      toast.success(state.message);

      const timer = setTimeout(() => {
        router.push("/login");
      }, 1000);

      return () => clearTimeout(timer);
    }
  }, [state, router]);

  useEffect(() => {
    if (!loading && isAuthenticated) {
      router.push("/");
    }
  }, [isAuthenticated, loading, router]);

  if (loading || isAuthenticated) {
    return (
      <div className="flex h-screen items-center justify-center">
        <LoadingSpinner width={64} height={64} />
      </div>
    );
  }

  return (
    <AuthCard
      title="Register"
      description="Create an account to start streaming."
      footerText="Already have an account?"
      footerLink="/login"
      footerLinkText="Login"
    >
      <form className="grid gap-4" action={formAction}>
        {state.message && (
          <Alert variant={state.success ? "default" : "destructive"}>
            <AlertTitle>
              {state.success ? "Success!" : "Registration Failed"}
            </AlertTitle>
            <AlertDescription>{state.message}</AlertDescription>
          </Alert>
        )}
        <div className="grid gap-2">
          <Label htmlFor="username" className="text-muted-foreground">
            Username
          </Label>
          <Input
            id="username"
            name="username"
            placeholder="Your username"
            required
          />
          {state.errors?.username && (
            <p className="text-sm text-red-500">{state.errors.username[0]}</p>
          )}
        </div>
        <div className="grid gap-2">
          <Label htmlFor="email" className="text-muted-foreground">
            Email
          </Label>
          <Input
            id="email"
            name="email"
            type="email"
            placeholder="john_doe@example.com"
            required
          />
          {state.errors?.email && (
            <p className="text-sm text-red-500">{state.errors.email[0]}</p>
          )}
        </div>
        <div className="grid gap-2">
          <Label htmlFor="password" className="text-muted-foreground">
            Password
          </Label>
          <Input id="password" name="password" type="password" required />
          {state.errors?.password && (
            <p className="text-sm text-red-500">{state.errors.password[0]}</p>
          )}
        </div>
        <SubmitButton className="w-full">Create Account</SubmitButton>
        <GoogleButton />
      </form>
    </AuthCard>
  );
}
