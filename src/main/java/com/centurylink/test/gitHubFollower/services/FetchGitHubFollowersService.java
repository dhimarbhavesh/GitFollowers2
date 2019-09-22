package com.centurylink.test.gitHubFollower.services;

import java.util.List;

import com.centurylink.test.gitHubFollower.model.FollowerResponse;

public interface FetchGitHubFollowersService {

	List<FollowerResponse> getFollowers(String userId,int depth);
}
