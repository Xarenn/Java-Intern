package com.nn.octocat.controller;

import com.nn.octocat.domain.User;
import com.nn.octocat.service.UserService;
import com.nn.octocat.service.exceptions.GithubException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/{userName}/info")
  public ResponseEntity<User> userInfo(@PathVariable String userName) throws GithubException {
    return new ResponseEntity<User>(userService.getUserFromGithub(userName), HttpStatus.OK);
  }

}
