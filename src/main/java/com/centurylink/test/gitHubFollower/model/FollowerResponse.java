package com.centurylink.test.gitHubFollower.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
@SuppressWarnings("unused")
public class FollowerResponse {

	@JsonProperty("login")
	private String login;
	@JsonProperty("id")
	private int id;
	@JsonProperty("node_id")
	private String node_id;
	@JsonProperty("avatar_url")
	private String avatar_url;
	@JsonProperty("gravatar_id")
	private String gravatar_id;
	@JsonProperty("url")
	private String url;
	@JsonProperty("html_url")
	private String html_url;
	@JsonProperty("followers_url")
	private String followers_url;
	@JsonProperty("following_url")
	private String following_url;
	@JsonProperty("gists_url")
	private String gists_url;
	@JsonProperty("starred_url")
	private String starred_url;
	@JsonProperty("subscriptions_url")
	private String subscriptions_url;
	@JsonProperty("organizations_url")
	private String organizations_url;
	@JsonProperty("repos_url")
	private String repos_url;
	@JsonProperty("events_url")
	private String events_url;
	@JsonProperty("received_events_url")
	private String received_events_url;
	@JsonProperty("type")
	private String type;
	@JsonProperty("site_admin")
	private boolean site_admin;
	public String getLogin() {
		return login;
	}
	
}
