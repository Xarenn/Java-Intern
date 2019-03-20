package com.nn.octocat.domain;

import com.nn.octocat.domain.dto.UserDTO;

public class User {

  private long id;
  private String login;
  private String name;
  private String type;

  private String avatarUrl;
  private String createdAt;

  public User(UserDTO userDTO) {
    this.id = userDTO.getId();
    this.login = userDTO.getLogin();
    this.name = userDTO.getName();
    this.type = userDTO.getType();
    this.avatarUrl = userDTO.getAvatarUrl();
    this.createdAt = userDTO.getCreatedAt();
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public long getId() {
    return id;
  }

  public String getLogin() {
    return login;
  }

}
