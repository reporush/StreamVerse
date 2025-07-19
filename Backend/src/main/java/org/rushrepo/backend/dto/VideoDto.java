package org.rushrepo.backend.dto;

import java.time.Instant;
import java.util.List;

import org.rushrepo.backend.enums.VideoStatus;

public class VideoDto {
    private String id;
    private String title;
    private String description;
    private String channelId; 
    private String videoUrl;
    private String thumbnailUrl;
    private List<String> tags;
    private VideoStatus status; 
    private long viewCount;
    private long likes;
    private long dislikes;
    private Instant publishedAt;
    private Instant updatedAt;


    public VideoDto(String id, String title, String description, String channelId, String videoUrl, String thumbnailUrl,
            List<String> tags, VideoStatus status, long viewCount, long likes, long dislikes, Instant publishedAt,
            Instant updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.channelId = channelId;
        this.videoUrl = videoUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.tags = tags;
        this.status = status;
        this.viewCount = viewCount;
        this.likes = likes;
        this.dislikes = dislikes;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getChannelId() {
        return channelId;
    }


    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }


    public String getVideoUrl() {
        return videoUrl;
    }


    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }


    public String getThumbnailUrl() {
        return thumbnailUrl;
    }


    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }


    public List<String> getTags() {
        return tags;
    }


    public void setTags(List<String> tags) {
        this.tags = tags;
    }


    public VideoStatus getStatus() {
        return status;
    }


    public void setStatus(VideoStatus status) {
        this.status = status;
    }


    public long getViewCount() {
        return viewCount;
    }


    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }


    public long getLikes() {
        return likes;
    }


    public void setLikes(long likes) {
        this.likes = likes;
    }


    public long getDislikes() {
        return dislikes;
    }


    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }


    public Instant getPublishedAt() {
        return publishedAt;
    }


    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }


    public Instant getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    

    
}
