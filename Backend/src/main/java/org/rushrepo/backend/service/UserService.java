package org.rushrepo.backend.service;

import java.time.Instant;
import java.time.Clock;

import org.bson.types.ObjectId;
import org.rushrepo.backend.dto.RegisterRequest;
import org.rushrepo.backend.dto.UserDto;
import org.rushrepo.backend.model.User;
import org.rushrepo.backend.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Clock clock;

    public UserDto registerUser(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username sudah digunakan!");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email sudah terdaftar!");
        }

        User newUser = new User();
        newUser.setId(new ObjectId());
        newUser.setUsername(request.getUsername());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setCreatedAt(Instant.now(clock));

        // TODO: Buat nilai default untuk field lain

        
        User savedUser = userRepository.save(newUser);
        return new UserDto(
            savedUser.getId(), 
            savedUser.getUsername(), 
            savedUser.getEmail(), 
            savedUser.getAuthProvider(),
            savedUser.getDisplayName(),
            savedUser.getProfileImageUrl(),
            savedUser.getSubscribeToChannelIds(),
            savedUser.getWatchHistoryVideosIds(),
            savedUser.getCreatedAt(),
            savedUser.getUpdatedAt());
    }
    public UserDto getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User tidak ditemukan: " + username));
        
        return new UserDto(
            user.getId(), 
            user.getUsername(), 
            user.getEmail(), 
            user.getAuthProvider(),
            user.getDisplayName(),
            user.getProfileImageUrl(),
            user.getSubscribeToChannelIds(),
            user.getWatchHistoryVideosIds(),
            user.getCreatedAt(),
            user.getUpdatedAt());
    }
}
