package com.nn.octocat.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.nn.octocat.BaseSpringTest;
import java.nio.charset.Charset;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserRestControllerTest extends BaseSpringTest {


  private String USER_NAME = "The Octocat";
  private int ID = 583231;
  private String USER_LOGIN = "octocat";
  private String TYPE = "User";
  private String AVATAR_URL = "https://avatars3.githubusercontent.com/u/583231?v=4";
  private String CREATED_AT = "2011-01-25T18:44:36Z";

  @LocalServerPort
  private static int port;

  private static final String CORRECT_URL = "http://localhost:" + port + "/octocat/info";
  private static final String WRONG_URL = "http://localhost:" + port + "\"\"/info";

  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8")
  );

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void getCorrectUser() throws Exception {

      mockMvc.perform(get(CORRECT_URL))
          .andExpect(status().isOk())
          .andExpect(content().contentType(APPLICATION_JSON_UTF8))
          .andExpect(jsonPath("$.id", is(this.ID)))
          .andExpect(jsonPath("$.name", is(this.USER_NAME)))
          .andExpect(jsonPath("$.login", is(this.USER_LOGIN)))
          .andExpect(jsonPath("$.type", is(this.TYPE)))
          .andExpect(jsonPath("$.avatarUrl", is(this.AVATAR_URL)))
          .andExpect(jsonPath("$.createdAt", is(this.CREATED_AT)));
  }

  @Test()
  public void getWrongUser() throws Exception {
    mockMvc.perform(get(WRONG_URL))
        .andExpect(status().isNotFound());
  }

}
