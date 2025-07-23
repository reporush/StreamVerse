package org.rushrepo.backend.controller;

import jakarta.servlet.http.HttpServletResponse;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.rushrepo.backend.dto.LoginRequestDto;
import org.rushrepo.backend.dto.RegisterRequestDto;
import org.rushrepo.backend.dto.UserDto;
import org.rushrepo.backend.dto.UserResponseDto;
import org.rushrepo.backend.exception.ApiRequestException;
import org.rushrepo.backend.model.User;
import org.rushrepo.backend.service.JwtService;
import org.rushrepo.backend.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;
  private final UserService userService;
  private final JwtService jwtService;

  @PostMapping("/login")
  public ResponseEntity<UserResponseDto> createAuthenticationToken(
      @RequestBody LoginRequestDto loginRequest, HttpServletResponse response) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              loginRequest.getUsername(), loginRequest.getPassword()));
    } catch (BadCredentialsException e) {
      throw new ApiRequestException("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }

    final User userDetails =
        (User) userDetailsService.loadUserByUsername(loginRequest.getUsername());

    final String jwt = jwtService.generateToken(userDetails);

    ResponseCookie cookie =
        ResponseCookie.from("token", jwt)
            .httpOnly(true)
            .secure(false) // Set to true in production (HTTPS)
            .path("/")
            .maxAge(Duration.ofDays(1)) // Cookie lifetime
            .sameSite("Strict")
            .build();

    response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

    UserResponseDto userResponse =
        new UserResponseDto(
            userDetails.getUsername(),
            userDetails.getEmail(),
            userDetails.getRole(),
            userDetails.getDisplayName(),
            userDetails.getProfileImageUrl());

    return ResponseEntity.ok(userResponse);
  }

  @PostMapping("/logout")
  public ResponseEntity<Void> logout(HttpServletResponse response) {
    // Create a cookie with the same name but with maxAge=0 to clear it
    ResponseCookie cookie =
        ResponseCookie.from("token", "")
            .httpOnly(true)
            .secure(false) // Set to true in production
            .path("/")
            .maxAge(0) // Clear cookie immediately
            .sameSite("Strict")
            .build();

    response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

    return ResponseEntity.ok().build();
  }

  @PostMapping("/register")
  public ResponseEntity<UserDto> register(@RequestBody RegisterRequestDto request) {
    UserDto newUser = userService.registerUser(request);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }
}

