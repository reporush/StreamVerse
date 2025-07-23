package org.rushrepo.backend.exception;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiException {
  private final String message;
  private final HttpStatus httpStatus;
  private final ZonedDateTime timestamp;
}
