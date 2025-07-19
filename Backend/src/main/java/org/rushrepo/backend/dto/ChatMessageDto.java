package org.rushrepo.backend.dto;

import java.time.Instant;

import org.bson.types.ObjectId;

public class ChatMessageDto {
    private final ObjectId id;
    private ObjectId streamId;
    private ObjectId userId;
    private String message;
    private Instant timestamp;
    
    public ChatMessageDto(ObjectId id, ObjectId streamId, ObjectId userId, String message, Instant timestamp) {
        this.id = id;
        this.streamId = streamId;
        this.userId = userId;
        this.message = message;
        this.timestamp = timestamp;
    }
    public ObjectId getId() {
        return id;
    }
    public ObjectId getStreamId() {
        return streamId;
    }
    public void setStreamId(ObjectId streamId) {
        this.streamId = streamId;
    }
    public ObjectId getUserId() {
        return userId;
    }
    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    
}
