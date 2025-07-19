FROM ubuntu:22.04

# Environment setup
ENV DEBIAN_FRONTEND=noninteractive

# Install dependencies
RUN apt-get update && apt-get install -y \
    build-essential \
    libpcre3 libpcre3-dev \
    libssl-dev \
    zlib1g-dev \
    wget \
    git \
    ffmpeg \
    curl

# Install nginx with RTMP module
RUN cd /tmp && \
    wget http://nginx.org/download/nginx-1.25.3.tar.gz && \
    tar -zxvf nginx-1.25.3.tar.gz && \
    git clone https://github.com/arut/nginx-rtmp-module.git && \
    cd nginx-1.25.3 && \
    ./configure --with-http_ssl_module --add-module=../nginx-rtmp-module && \
    make && make install

# Copy config and scripts
COPY nginx.conf /usr/local/nginx/conf/nginx.conf
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Expose RTMP (1935) and HTTP (8080 for HLS playback)
EXPOSE 1935 8080

# Start nginx
CMD ["/entrypoint.sh"]
