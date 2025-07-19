package org.rushrepo.backend.model;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String fullName;
    private String username;
    private String email;
    private String password; // Hashed
    private String profilePictureUrl;

    private List<String> subscribeToChannelIds;

    private List<String> watchHistoryVideosIds;

    private Instant createdAt;
    private Instant updatedAt;

    public User(String id, String fullName, String username, String email, String password, String profilePictureUrl, List<String> subscribeToChannelIds, List<String> watchHistoryVideosIds, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePictureUrl = profilePictureUrl;
        this.subscribeToChannelIds = subscribeToChannelIds;
        this.watchHistoryVideosIds = watchHistoryVideosIds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public List<String> getSubscribeToChannelIds() {
        return subscribeToChannelIds;
    }

    public void setSubscribeToChannelIds(List<String> subscribeToChannelIds) {
        this.subscribeToChannelIds = subscribeToChannelIds;
    }

    public List<String> getWatchHistoryVideosIds() {
        return watchHistoryVideosIds;
    }

    public void setWatchHistoryVideosIds(List<String> watchHistoryVideosIds) {
        this.watchHistoryVideosIds = watchHistoryVideosIds;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }


    

    
}