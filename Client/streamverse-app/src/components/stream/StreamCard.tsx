import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import Image from "next/image";
import Link from "next/link";

interface StreamCardProps {
  stream: {
    id: string;
    title: string;
    channelName: string;
    thumbnailUrl: string;
  };
  className?: string;
}

export function StreamCard({ stream, className }: StreamCardProps) {
  return (
    <Link href={`/stream/${stream.channelName}`}>
      <Card
        className={`w-full max-w-sm transition-transform hover:-translate-y-2 hover:scale-105 ${className}`}
      >
        <CardHeader>
          <Image
            src={stream.thumbnailUrl}
            alt={stream.title}
            width={400}
            height={225}
            className="rounded-lg"
          />
        </CardHeader>
        <CardContent className="h-24">
          <CardTitle className="truncate">{stream.title}</CardTitle>
          <p className="text-muted-foreground">{stream.channelName}</p>
        </CardContent>
      </Card>
    </Link>
  );
}
