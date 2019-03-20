package com.nn.octocat.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nn.octocat.domain.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

  private long id;
  private String login;
  private String name;
  private String type;

  @JsonProperty("avatar_url")
  private String avatarUrl;

  @JsonProperty("created_at")
  private String createdAt;

  public UserDTO() { }

  public String getLogin() { return login; }

  public long getId() {
    return id;
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
}
