package org.rushrepo.backend.dto;

import java.time.Instant;
import java.util.Set;

public class ChannelDto {
    private String id;
    private String channelName;
    private String description;
    private String userId;
    private Set<String> subscriberIds;
    private Instant createdAt;

    public ChannelDto(String id, String channelName, String description, String userId, Set<String> subscriberIds, Instant createdAt) {
        this.id = id;
        this.channelName = channelName;
        this.description = description;
        this.userId = userId;
        this.subscriberIds = subscriberIds;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<String> getSubscriberIds() {
        return subscriberIds;
    }

    public void setSubscriberIds(Set<String> subscriberIds) {
        this.subscriberIds = subscriberIds;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }


    
}
