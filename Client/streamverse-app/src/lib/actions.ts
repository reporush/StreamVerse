"use server";

import { revalidatePath } from "next/cache";
import { redirect } from "next/navigation";
import { z } from "zod";

export type FormState = {
  success: boolean;
  message?: string;
  errors?: {
    username?: string[];
    email?: string[];
    password?: string[];
  };
};

// Mock API functions
async function mockApiLogin(data: FormData) {
  const email = data.get("email");
  console.log("Attempting login for:", email);
  await new Promise((resolve) => setTimeout(resolve, 1000));
  if (email === "test@example.com") {
    return { ok: true, json: () => ({ message: "Login successful" }) };
  } else {
    return {
      ok: false,
      status: 401,
      json: () => ({ message: "Invalid credentials" }),
    };
  }
}

async function mockApiRegister(data: FormData) {
  const email = data.get("email");
  console.log("Attempting registration for:", email);
  await new Promise((resolve) => setTimeout(resolve, 1000));
  if (email === "exists@example.com") {
    return {
      ok: false,
      status: 409,
      json: () => ({ message: "User with this email already exists" }),
    };
  } else {
    return { ok: true, json: () => ({ message: "Registration successful" }) };
  }
}

const LoginSchema = z.object({
  email: z.email("Invalid email address."),
  password: z.string().min(1, "Password cannot be empty."),
});

const RegisterSchema = z.object({
  username: z.string().min(3, "Username must be at least 3 characters."),
  email: z.email("Invalid email address."),
  password: z.string().min(6, "Password must be at least 6 characters."),
});

export async function login(
  _: FormState,
  formData: FormData,
): Promise<FormState> {
  const validatedFields = LoginSchema.safeParse(
    Object.fromEntries(formData.entries()),
  );

  if (!validatedFields.success) {
    return {
      success: false,
      errors: validatedFields.error.flatten().fieldErrors,
    };
  }

  try {
    const response = await mockApiLogin(formData);
    if (!response.ok) {
      const errorData = response.json();
      return { success: false, message: errorData.message || "Login failed." };
    }
  } catch (error) {
    console.error("Login action error:", error);
    return { success: false, message: "An unexpected error occurred." };
  }

  revalidatePath("/");
  redirect("/profile");
}

export async function register(
  _: FormState,
  formData: FormData,
): Promise<FormState> {
  const validatedFields = RegisterSchema.safeParse(
    Object.fromEntries(formData.entries()),
  );

  if (!validatedFields.success) {
    return {
      success: false,
      errors: validatedFields.error.flatten().fieldErrors,
    };
  }

  try {
    const response = await mockApiRegister(formData);
    if (!response.ok) {
      const errorData = response.json();
      return {
        success: false,
        message: errorData.message || "Registration failed.",
      };
    }
  } catch (error) {
    console.error("Register action error:", error);
    return { success: false, message: "An unexpected error occurred." };
  }

  redirect("/login?registered=true");
}
