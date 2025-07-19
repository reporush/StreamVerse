import VideoPlayer from "@/components/stream/VideoPlayer";
import ChatBox from "@/components/stream/ChatBox";
import { mockStreams } from "@/lib/mock-data";

export default async function StreamPage({
  params,
}: {
  params: Promise<{ channelName: string }>;
}) {
  const { channelName } = await params;

  const streamData = mockStreams.find((e) => e.channelName == channelName);

  return (
    <div className="flex flex-col gap-4">
      <h1 className="text-3xl">{streamData?.title}</h1>
      <p className="text-2xl">{channelName}</p>
      <div className="grid grid-cols-3 gap-x-4 min-h-[600px]">
        <div className="col-span-2">
          <VideoPlayer channelName={channelName} />
        </div>
        <div className="col-span-1">
          <ChatBox channelName={channelName} />
        </div>
      </div>
    </div>
  );
}
