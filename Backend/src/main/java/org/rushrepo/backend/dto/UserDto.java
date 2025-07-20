package org.rushrepo.backend.dto;

import java.time.Instant;
import java.util.List;

import org.bson.types.ObjectId;
import org.rushrepo.backend.enums.AuthProvider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
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
}
