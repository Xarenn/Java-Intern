package com.nn.octocat.service;

import com.nn.octocat.BaseSpringTest;
import com.nn.octocat.domain.User;
import com.nn.octocat.service.exceptions.GithubException;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends BaseSpringTest {

  private static final String USER_NAME = "The Octocat";
  private static final long ID = 583231;
  private static final String USER_LOGIN = "octocat";
  private static final String TYPE = "User";
  private static final String AVATAR_URL = "https://avatars3.githubusercontent.com/u/583231?v=4";
  private static final String CREATED_AT = "2011-01-25T18:44:36Z";

  private static final String WRONG_USER_LOGIN = "\"\"";

  @Autowired
  private UserService userService;

  @Test
  public void getCorrectUserFromGithub() throws GithubException {
    User userResponseEntity = userService.getUserFromGithub(this.USER_LOGIN);

    BDDAssertions.then(userResponseEntity.getId()).isEqualTo(this.ID);
    BDDAssertions.then(userResponseEntity.getName()).isEqualTo(this.USER_NAME);
    BDDAssertions.then(userResponseEntity.getLogin()).isEqualTo(this.USER_LOGIN);
    BDDAssertions.then(userResponseEntity.getAvatarUrl()).isEqualTo(this.AVATAR_URL);
    BDDAssertions.then(userResponseEntity.getCreatedAt()).isEqualTo(this.CREATED_AT);

  }

  @Test(expected = GithubException.class)
  public void getWrongUserFromGithub() throws GithubException {
    User userResponseEntity = userService.getUserFromGithub(WRONG_USER_LOGIN);
  }
}
