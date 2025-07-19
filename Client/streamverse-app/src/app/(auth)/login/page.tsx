"use client";

import { useActionState, useState } from "react";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { AuthCard } from "@/components/auth/AuthCard";
import { GoogleButton } from "@/components/auth/GoogleButton";
import { login, FormState } from "@/lib/actions";
import { SubmitButton } from "@/components/auth/SubmitButton";
import { Alert, AlertDescription, AlertTitle } from "@/components/ui/alert";

const initialState: FormState = {
  success: false,
  message: "",
  errors: {},
};

export default function LoginPage() {
  const [state, formAction] = useActionState(login, initialState);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  return (
    <AuthCard
      title="Login"
      description="Welcome back! Please enter your details."
      footerText="Don't have an account?"
      footerLink="/register"
      footerLinkText="Register"
    >
      <form className="grid gap-4" action={formAction}>
        {state.message && (
          <Alert variant={state.success ? "default" : "destructive"}>
            <AlertTitle>
              {state.success ? "Success" : "Login Failed"}
            </AlertTitle>
            <AlertDescription>{state.message}</AlertDescription>
          </Alert>
        )}
        <div className="grid gap-2">
          <Label htmlFor="email" className="text-muted-foreground">
            Email
          </Label>
          <Input
            id="email"
            name="email"
            type="email"
            placeholder="john_doe@example.com"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
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
          <Input
            id="password"
            name="password"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          {state.errors?.password && (
            <p className="text-sm text-red-500">{state.errors.password[0]}</p>
          )}
        </div>
        <SubmitButton className="w-full">Login</SubmitButton>
        <GoogleButton />
      </form>
    </AuthCard>
  );
}
