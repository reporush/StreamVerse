# ---- Build Stage ----

# This stage installs build tools, downloads source code, and compiles Nginx.

FROM alpine:3.20 AS builder



# Install build-time dependencies

RUN apk add --no-cache \
    build-base \
    pcre-dev \
    openssl-dev \
    zlib-dev \
    wget \
    git



# Download and compile Nginx

RUN cd /tmp && \
    wget http://nginx.org/download/nginx-1.25.3.tar.gz && \
    tar -zxvf nginx-1.25.3.tar.gz && \
    git clone https://github.com/arut/nginx-rtmp-module.git && \
    cd nginx-1.25.3 && \
    ./configure --with-http_ssl_module --add-module=../nginx-rtmp-module && \
    make && make install





# ---- Final Stage ----

# This stage creates the final, small image. It only installs runtime dependencies

# and copies the compiled Nginx from the 'builder' stage.

FROM alpine:3.20

# Install only the necessary runtime dependencies

RUN apk add --no-cache \
    pcre \
    openssl \
    zlib \
    ffmpeg \
    curl



# Copy the compiled Nginx binary and its modules from the builder stage

COPY --from=builder /usr/local/nginx /usr/local/nginx

# sesuai dengan path dari entrypoint.sh lo `/usr/local/nginx/sbin/nginx`
# Copy your custom config and entrypoint script
COPY nginx.conf /usr/local/nginx/conf/nginx.conf
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh
RUN mkdir -p /var/www/hls
# Expose RTMP (1935) and HTTP (8080 for HLS playback)

EXPOSE 1935 8080
# Start nginx

CMD ["/entrypoint.sh"]