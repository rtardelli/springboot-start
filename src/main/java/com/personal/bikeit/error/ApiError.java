package com.personal.bikeit.error;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

  /*
  *  It will be anything from 4xx to signalize client errors or 5xx to mean server errors. A common scenario is a http
  * code 400 that means a BAD_REQUEST, when the client, for example, sends an improperly formatted field, like an
  * invalid email address.
  */
  private HttpStatus httpStatus;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  /* holds the date-time instance of when the error happened.*/
  private LocalDateTime timestamp;
  /*holds a user-friendly message about the error.*/
  private String message;
  /* holds a system message describing the error in more detail.*/
  private String debugError;
  /*holds an array of sub-errors that happened. This is used for representing multiple errors in a single call. An example would be validation errors in which multiple fields have failed the validation.*/
  private List<ApiSubError> subErrors;

  private ApiError() {
    this.timestamp = LocalDateTime.now();
  }

  public ApiError(HttpStatus httpStatus) {
    this();
    this.httpStatus = httpStatus;
  }

  public ApiError(HttpStatus httpStatus, String message, Throwable t) {
    this(httpStatus);
    this.message = message;
    this.debugError = t.getLocalizedMessage();
  }

  public ApiError(HttpStatus httpStatus, Throwable t) {
    this(httpStatus, "Unexpected error", t);
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  public String getDebugError() {
    return debugError;
  }

  public List<ApiSubError> getSubErrors() {
    return subErrors;
  }
}
