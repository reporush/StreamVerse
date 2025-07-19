package org.rushrepo.backend.dto;

import java.time.Instant;
import java.util.List;

import org.bson.types.ObjectId;
import org.rushrepo.backend.enums.StreamStatus;

public class VideoStreamDto {
    private final ObjectId id;
    private ObjectId channelId;

    private String title;
    private String description;
    private String streamKey;
    private StreamStatus streamStatus; 
    private String thumbnailUrl;
    private List<String> tags;
    
    private Instant startTime;
    private Instant endTime;
    private long peakViewersCount;

    public VideoStreamDto(ObjectId id, ObjectId channelId, String title, String description, String streamKey,
            StreamStatus streamStatus, String thumbnailUrl, List<String> tags, Instant startTime, Instant endTime,
            long peakViewersCount) {
        this.id = id;
        this.channelId = channelId;
        this.title = title;
        this.description = description;
        this.streamKey = streamKey;
        this.streamStatus = streamStatus;
        this.thumbnailUrl = thumbnailUrl;
        this.tags = tags;
        this.startTime = startTime;
        this.endTime = endTime;
        this.peakViewersCount = peakViewersCount;
    }

    public ObjectId getId() {
        return id;
    }

    public ObjectId getChannelId() {
        return channelId;
    }

    public void setChannelId(ObjectId channelId) {
        this.channelId = channelId;
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

    public String getStreamKey() {
        return streamKey;
    }

    public void setStreamKey(String streamKey) {
        this.streamKey = streamKey;
    }

    public StreamStatus getStreamStatus() {
        return streamStatus;
    }

    public void setStreamStatus(StreamStatus streamStatus) {
        this.streamStatus = streamStatus;
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

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public long getPeakViewersCount() {
        return peakViewersCount;
    }

    public void setPeakViewersCount(long peakViewersCount) {
        this.peakViewersCount = peakViewersCount;
    }

    

    
}
