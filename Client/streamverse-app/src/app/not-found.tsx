import Link from "next/link";
import { Button } from "@/components/ui/button";

export default function NotFound() {
  return (
    <div className="flex h-screen flex-col items-center justify-center bg-background text-center">
      <h1 className="text-9xl font-bold text-primary">404</h1>
      <h2 className="mt-4 text-3xl font-semibold tracking-tight">
        Page Not Found
      </h2>
      <p className="mt-2 text-muted-foreground">
        Sorry, the page you are looking for does not exist.
      </p>
      <Link href="/" className="mt-6">
        <Button>Go Back Home</Button>
      </Link>
    </div>
  );
}
