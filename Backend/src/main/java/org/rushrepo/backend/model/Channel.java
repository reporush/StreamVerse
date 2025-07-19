package org.rushrepo.backend.model;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "channels")
public class Channel {
    @Id
    private final ObjectId id;
    private ObjectId userId;
    private String name;
    private String description;

    private boolean isLive;
    private long followersCount;
    private Instant createdAt;

    public Channel(ObjectId id, ObjectId userId, String name, String description, boolean isLive, long followersCount,
            Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.isLive = isLive;
        this.followersCount = followersCount;
        this.createdAt = createdAt;
    }

    public ObjectId getId() {
        return id;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }

    public long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(long followersCount) {
        this.followersCount = followersCount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    
    

}