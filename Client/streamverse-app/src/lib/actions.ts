"use server";

import { z } from "zod";

export interface FormState {
  success: boolean;
  message: string;
  errors?: {
    username?: string[];
    email?: string[];
    password?: string[];
  };
}

// Define the Zod schema for server-side validation
const RegisterSchema = z.object({
  username: z.string().min(3, "Username must be at least 3 characters."),
  email: z.string().email("Please enter a valid email address."),
  password: z.string().min(6, "Password must be at least 6 characters."),
});

export async function register(
  previousState: FormState,
  formData: FormData,
): Promise<FormState> {
  // 1. Extract form data
  const data = Object.fromEntries(formData.entries());

  const validatedFields = RegisterSchema.safeParse(data);

  // 3. If validation fails, return errors to the form
  if (!validatedFields.success) {
    const fieldErrors = validatedFields.error.flatten().fieldErrors;
    return {
      success: false,
      message: "Please correct the errors below.",
      errors: fieldErrors,
    };
  }

  try {
    const response = await fetch("http://localhost:6969/api/auth/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(validatedFields.data),
    });

    // 5. Handle non-successful responses from the API
    if (!response.ok) {
      const errorData = await response.json();
      return {
        success: false,
        message: errorData.message || "Registration failed on the server.",
        errors: {},
      };
    }

    return {
      success: true,
      message: "Account created successfully! You can now log in.",
      errors: {},
    };
  } catch (error) {
    return {
      success: false,
      message: "An unexpected error occurred. Please try again later.",
      errors: {},
    };
  }
}
