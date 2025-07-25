package org.rushrepo.backend.controller;

import lombok.RequiredArgsConstructor;
import org.rushrepo.backend.dto.UserDto;
import org.rushrepo.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/me")
  public ResponseEntity<UserDto> getMyProfile() {
    try {
      UserDto currentUser = userService.getCurrentUser();
      return ResponseEntity.ok(currentUser);
    } catch (Exception e) {
      return ResponseEntity.status(401).body(null);
    }
  }
}

