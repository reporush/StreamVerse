package org.rushrepo.backend.exception;

import io.jsonwebtoken.ExpiredJwtException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(value = {ApiRequestException.class})
  public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {

    ApiException apiException =
        new ApiException(e.getMessage(), e.getHttpStatus(), ZonedDateTime.now(ZoneId.of("Z")));

    return new ResponseEntity<>(apiException, apiException.getHttpStatus());
  }

  @ExceptionHandler(value = {ExpiredJwtException.class})
  public ResponseEntity<Object> handleExpiredJwtException(ExpiredJwtException e) {
    ApiException apiException =
        new ApiException(
            "JWT has expired",
            HttpStatus.UNAUTHORIZED, // Return 401 Unauthorized
            ZonedDateTime.now(ZoneId.of("Z")));
    return new ResponseEntity<>(apiException, apiException.getHttpStatus());
  }
}
