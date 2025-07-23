package org.rushrepo.backend.service;

import java.time.Clock;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.rushrepo.backend.dto.RegisterRequestDto;
import org.rushrepo.backend.dto.UserDto;
import org.rushrepo.backend.exception.ApiRequestException;
import org.rushrepo.backend.model.User;
import org.rushrepo.backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final Clock clock;

  /**
   * Register new User in database and returns User DTO
   *
   * @return UserProfileDto
   */
  public UserDto registerUser(RegisterRequestDto request) {
    if (userRepository.findByUsername(request.getUsername()).isPresent()) {
      throw new ApiRequestException("Username alreaday exist!", HttpStatus.BAD_REQUEST);
    }
    if (userRepository.findByEmail(request.getEmail()).isPresent()) {
      throw new ApiRequestException("Email already registered!", HttpStatus.BAD_REQUEST);
    }

    // User Register default value
    User newUser =
        User.builder()
            .id(new ObjectId())
            .username(request.getUsername())
            .displayName(request.getUsername())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .createdAt(Instant.now(clock))
            .build();

    // TODO: Buat nilai default untuk field lain

    User savedUser = userRepository.save(newUser);
    return UserDto.fromUser(savedUser);
  }

  public UserDto getCurrentUser() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    String username;
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    } else {
      username = principal.toString();
    }

    User user =
        userRepository
            .findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User tidak ditemukan: " + username));

    return UserDto.fromUser(user);
  }
}
