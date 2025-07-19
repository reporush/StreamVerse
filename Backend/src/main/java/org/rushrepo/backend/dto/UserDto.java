package org.rushrepo.backend.dto;

import java.time.Instant;
import java.util.List;

import org.bson.types.ObjectId;
import org.rushrepo.backend.enums.AuthProvider;

public class UserDto{
    private final ObjectId id;

    private String username;
    private String email;
    private AuthProvider authProvider;

    private String displayName;
    private String profileImageUrl;

    private List<String> subscribeToChannelIds;
    private List<String> watchHistoryVideosIds; 
    private Instant createdAt;
    private Instant updatedAt;
    
    public UserDto(ObjectId id, String username, String email, AuthProvider authProvider, String displayName,
            String profileImageUrl, List<String> subscribeToChannelIds, List<String> watchHistoryVideosIds,
            Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.authProvider = authProvider;
        this.displayName = displayName;
        this.profileImageUrl = profileImageUrl;
        this.subscribeToChannelIds = subscribeToChannelIds;
        this.watchHistoryVideosIds = watchHistoryVideosIds;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ObjectId getId() {
        return id;
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

    public AuthProvider getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
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
