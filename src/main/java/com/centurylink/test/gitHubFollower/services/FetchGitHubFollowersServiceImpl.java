package com.centurylink.test.gitHubFollower.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.centurylink.test.gitHubFollower.model.FollowerResponse;
import com.centurylink.test.gitHubFollower.utils.AppConstants;

@Configuration
@Service
@Qualifier(AppConstants.FOLLOWER_SERVICE_URL)
public class FetchGitHubFollowersServiceImpl implements FetchGitHubFollowersService {

	@Autowired
	private Environment env;

	@Autowired
	private RestTemplate restTemplate;

	public List<FollowerResponse> getFollowers(String userId,int depth) {
		List<FollowerResponse> finalList = new ArrayList<>(5);

		invokeAPIOperation(userId, finalList,depth);
		return finalList;

	}

	private String createUrl(String userId) {
		String gitUrl = env.getProperty(AppConstants.GITHUB_URL);
		StringBuilder builder = new StringBuilder(gitUrl);
		builder.append(userId);
		builder.append(AppConstants.SLASH);
		builder.append(AppConstants.FOLLOWERS);
		return builder.toString();

	}

	private void invokeAPIOperation(String userId, List<FollowerResponse> followerResponse,int depth) {
		int LEVEL = 1;
		callNestedFollower(userId, followerResponse, LEVEL,depth);
	}

	private void callNestedFollower(String userId, List<FollowerResponse> response, int level,int depth) {
		FollowerResponse[] responseLocal = null;
		List<String> userList = new ArrayList<>(5);
		responseLocal = restTemplate.getForObject(createUrl(userId), FollowerResponse[].class);
		int COUNT = 0;
		for (FollowerResponse resp1 : responseLocal) {
			if (COUNT < 5) {
				response.add(resp1);
				userList.add(resp1.getLogin());
				COUNT++;
			}
			if (COUNT == 5) {
				break;
			}
		}
		for (String userIdTmp : userList) {
			if (level < depth) {
				level = level + 1;
				callNestedFollower(userIdTmp, response, level,depth);
			}
		}
	}
}
