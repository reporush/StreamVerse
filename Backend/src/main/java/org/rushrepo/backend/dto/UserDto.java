package org.rushrepo.backend.dto;

import java.time.Instant;

public class UserDto{
    private String id;
    private String username;
    private String email;
    private String channelId;
    private Instant createdAt;
    
    public UserDto(String id, String username, String email, String channelId, Instant createdAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.channelId = channelId;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    
}
