import { Toaster } from "@/components/ui/sonner";
import { Header } from "@/components/layout/Header";
import { Sidebar } from "@/components/layout/Sidebar";

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <>
      <Header />
      <div className="flex h-full">
        <Sidebar />
        <main className="h-full flex-1 p-6 min-w-0">{children}</main>
      </div>
      <Toaster />
    </>
  );
}
