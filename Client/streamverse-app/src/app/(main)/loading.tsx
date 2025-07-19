import LoadingSpinner from "@/components/ui/loading-spinner";

const Loading = () => {
  return (
    <div className="flex flex-col gap-4 items-center justify-center">
      <LoadingSpinner width={256} height={256} />
      <h1 className="text-4xl">Loading Stream....</h1>
    </div>
  );
};

export default Loading;
