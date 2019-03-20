package com.nn.octocat.service.exceptions;

import com.nn.octocat.controller.UserController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(assignableTypes = UserController.class)
public class RestResponseExceptionAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value
      = { GithubException.class })
  protected ResponseEntity<Object> handleGithubException(Exception ex, WebRequest request) {
    String bodyOfResponse = "Github: user not found or GitHub API is down";
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

}
