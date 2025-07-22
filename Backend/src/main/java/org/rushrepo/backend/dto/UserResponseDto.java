package org.rushrepo.backend.dto;

import org.rushrepo.backend.enums.UserRole;

public record UserResponseDto(
    String username, String email, UserRole role, String displayName, String profileImageUrl) {}

