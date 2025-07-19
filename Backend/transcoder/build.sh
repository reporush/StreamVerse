#!/bin/bash

# Set a default image name if not passed
IMAGE_NAME="nginx-rtmp-transcoder"

# Optional argument: custom image name
if [ ! -z "$1" ]; then
  IMAGE_NAME=$1
fi

# Build the Docker image
echo "🔨 Building Docker image: $IMAGE_NAME"
docker build -t $IMAGE_NAME .

# Done
echo "✅ Build complete. Run it with:"
echo "   docker run -it --rm -p 1935:1935 -p 8080:8080 $IMAGE_NAME"
