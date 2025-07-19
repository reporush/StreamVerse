// This file will contain all authentication-related functions.

export type RegisterFormData = {
  username: string;
  email: string;
  password:  string;
};

export type LoginFormData = {
  email: string;
  password:  string;
};

export const handleRegister = async (formData: RegisterFormData) => {
  // TODO: Implement API call to the backend for registration
  console.log(formData);
};

export const handleLogin = async (formData: LoginFormData) => {
  // TODO: Implement API call to the backend for login
  console.log(formData);
};
