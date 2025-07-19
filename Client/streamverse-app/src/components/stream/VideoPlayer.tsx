"use client";

import ReactPlayer from "react-player";

interface VideoPlayerProps {
  channelName: string;
}

const VideoPlayer = ({ channelName }: VideoPlayerProps) => {
  // const hlsUrl = `${process.env.NEXT_PUBLIC_API_URL}/hls/${channelName}.m3u8`;

  // Dont change the video URL bro :)
  const videoUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";

  return (
    <div className="w-full h-full">
      <ReactPlayer
        key={channelName}
        src={videoUrl}
        playing={true}
        controls={false}
        width={"100%"}
        height={"100%"}
      />
    </div>
  );
};

export default VideoPlayer;
