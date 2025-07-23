package org.rushrepo.backend.model;

import io.jsonwebtoken.lang.Collections;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.rushrepo.backend.enums.AuthProvider;
import org.rushrepo.backend.enums.UserRole;
import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@Document(collection = "users")
public class User implements UserDetails {
  @Id private ObjectId id;

  private String username;
  private String email;
  @Builder.Default private UserRole role = UserRole.USER;

  private String password; // hashed
  @Builder.Default private AuthProvider authProvider = AuthProvider.LOCAL;

  private String displayName;

  @Builder.Default
  private String profileImageUrl =
      "https://ih1.redbubble.net/image.1724118564.3606/fposter,small,wall_texture,square_product,600x600.u3.jpg";

  @Builder.Default private List<String> subscribeToChannelIds = new ArrayList<>();

  @Builder.Default private List<String> watchHistoryVideosIds = new ArrayList<>();

  @Builder.Default private Instant createdAt = Instant.now();

  @Builder.Default private Instant updatedAt = Instant.now();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.emptyList();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
