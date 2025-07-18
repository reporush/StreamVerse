
"use client";

import { useState } from "react";
import { Button } from "@/components/ui/button";
import { ChevronsLeft, ChevronsRight } from "lucide-react";
import { cn } from "@/lib/utils";

export function Sidebar() {
  const [isCollapsed, setIsCollapsed] = useState(false);

  const toggleSidebar = () => {
    setIsCollapsed(!isCollapsed);
  };

  return (
    <aside
      className={cn(
        "sticky top-16 h-[calc(100vh-4rem)] flex-shrink-0 border-r bg-card p-4 transition-all duration-300 hidden md:flex md:flex-col",
        isCollapsed ? "w-16" : "w-64"
      )}
    >
      <div className="flex items-center justify-between">
        {!isCollapsed && (
          <h2 className="text-lg font-semibold">Followed Channels</h2>
        )}
        <Button variant="ghost" size="icon" onClick={toggleSidebar}>
          {isCollapsed ? <ChevronsRight /> : <ChevronsLeft />}
        </Button>
      </div>
      {/* Add followed channels list here */}
    </aside>
  );
}
