package org.rushrepo.backend.model;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.lang.Collections;

import org.rushrepo.backend.enums.AuthProvider;

@Data 
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User implements UserDetails{
    @Id
    private ObjectId id;

    private String username;
    private String email;
    
    private String password; // hashed
    private AuthProvider authProvider;

    private String displayName;
    private String profileImageUrl;

    private List<String> subscribeToChannelIds;
    private List<String> watchHistoryVideosIds;
    private Instant createdAt;
    private Instant updatedAt;

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