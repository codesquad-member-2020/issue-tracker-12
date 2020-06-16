package dev.codesquad.issuetracker.common.oauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GithubUser {

  @JsonProperty("login")
  private String userId;

  @JsonProperty("avatar_url")
  private String profileUrl;

  public GithubUser() {}
}
