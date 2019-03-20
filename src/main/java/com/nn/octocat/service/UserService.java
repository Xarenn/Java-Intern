package com.nn.octocat.service;

import com.nn.octocat.domain.User;
import com.nn.octocat.domain.dto.UserDTO;
import com.nn.octocat.service.exceptions.GithubException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

  private static String apiUrl = "https://api.github.com/users/";

  private final RestTemplate restTemplate;

  UserService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public User getUserFromGithub(String userName) throws GithubException {
    String url = apiUrl + userName;
    try {
      ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);

      return new User(response.getBody());
    } catch (HttpClientErrorException e) {
      throw new GithubException();
    }
  }

}
