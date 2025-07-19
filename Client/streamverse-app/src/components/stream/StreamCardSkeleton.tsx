
import { Card, CardContent, CardHeader } from "@/components/ui/card";
import { Skeleton } from "@/components/ui/skeleton";

export function StreamCardSkeleton() {
  return (
    <Card className="w-full max-w-sm">
      <CardHeader>
        <Skeleton className="h-[225px] w-full rounded-lg" />
      </CardHeader>
      <CardContent>
        <Skeleton className="h-4 w-3/4" />
        <Skeleton className="mt-2 h-4 w-1/2" />
      </CardContent>
    </Card>
  );
}
