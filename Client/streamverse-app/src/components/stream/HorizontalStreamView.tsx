"use client";

import { StreamCard } from "./StreamCard";

interface HorizontalStreamViewProps {
  streams: {
    id: string;
    title: string;
    channelName: string;
    thumbnailUrl: string;
  }[];
}

export function HorizontalStreamView({ streams }: HorizontalStreamViewProps) {
  const duplicatedStreams = [...streams, ...streams];

  return (
    <div className="group relative w-full overflow-hidden">
      <div className="flex animate-scroll space-x-4 group-hover:pause py-4">
        {duplicatedStreams.map((stream, index) => (
          <div key={`${stream.id}-${index}`}>
            <StreamCard stream={stream} className="w-[900px]" />
          </div>
        ))}
      </div>
    </div>
  );
}
