
import { Header } from "@/components/layout/Header";
import { Sidebar } from "@/components/layout/Sidebar";
import { HorizontalStreamView } from "@/components/stream/HorizontalStreamView";
import { StreamCard } from "@/components/stream/StreamCard";
import { mockStreams } from "@/lib/mock-data";

export default function HomePage() {
  const recommendedStreams = mockStreams.slice(0, 5);
  const allStreams = mockStreams.slice(5);

  return (
    <div className="flex h-screen flex-col">
      <Header />
      <div className="flex flex-1 overflow-hidden">
        <Sidebar />
        <main className="flex-1 overflow-y-auto p-6">
          <section>
            <h2 className="text-2xl font-bold tracking-tight">
              Recommended For You
            </h2>
            <p className="text-muted-foreground">
              Channels we think you&apos;ll like.
            </p>
            <div className="mt-4">
              <HorizontalStreamView streams={recommendedStreams} />
            </div>
          </section>
          <section className="mt-8">
            <h2 className="text-2xl font-bold tracking-tight">
              All Live Channels
            </h2>
            <div className="mt-4 grid grid-cols-1 gap-4 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
              {allStreams.map((stream) => (
                <StreamCard key={stream.id} stream={stream} />
              ))}
            </div>
          </section>
        </main>
      </div>
    </div>
  );
}
