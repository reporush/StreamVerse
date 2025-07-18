import React from "react";
import { HorizontalStreamView } from "@/components/stream/HorizontalStreamView";
import { StreamCard } from "@/components/stream/StreamCard";
import { mockStreams } from "@/lib/mock-data";

export default function HomePage() {
  const recommendedStreams = mockStreams.slice(0, 5);
  const allStreams = mockStreams.slice(5);

  return (
    <>
      <section>
        <h2 className="text-2xl font-bold tracking-tight">
          Recommended For You
        </h2>
        <p className="text-muted-foreground">
          Channels we think you&apos;ll like.
        </p>
        <div className="mt-4 overflow-hidden">
          <HorizontalStreamView streams={recommendedStreams} />
        </div>
      </section>
      <section className="mt-8">
        <h2 className="text-2xl font-bold tracking-tight">All Live Channels</h2>
        <div className="mt-4 grid grid-cols-1 gap-4 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
          {allStreams.map((stream: any) => (
            <StreamCard key={stream.id} stream={stream} />
          ))}
        </div>
      </section>
    </>
  );
}
