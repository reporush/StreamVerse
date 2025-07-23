package org.rushrepo.backend.dto;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.rushrepo.backend.enums.UserRole;
import org.rushrepo.backend.model.User;

@Data
@AllArgsConstructor
public class UserDto {

  private String username;
  private String email;
  private UserRole role = UserRole.USER;

  private String displayName;
  private String profileImageUrl;

  private List<String> subscribeToChannelIds;
  private List<String> watchHistoryVideosIds;
  private Instant createdAt;
  private Instant updatedAt;

  // Static factory method
  public static UserDto fromUser(User user) {
    return new UserDto(
        user.getUsername(),
        user.getEmail(),
        user.getRole(),
        user.getDisplayName(),
        user.getProfileImageUrl(),
        user.getSubscribeToChannelIds(),
        user.getWatchHistoryVideosIds(),
        user.getCreatedAt(),
        user.getUpdatedAt());
  }
}
