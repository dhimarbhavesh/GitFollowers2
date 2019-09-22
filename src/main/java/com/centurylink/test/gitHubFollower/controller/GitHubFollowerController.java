package com.centurylink.test.gitHubFollower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.centurylink.test.gitHubFollower.model.FollowerResponse;
import com.centurylink.test.gitHubFollower.services.FetchGitHubFollowersService;
import com.centurylink.test.gitHubFollower.utils.AppConstants;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1")
public class GitHubFollowerController {

	@Autowired
	@Qualifier(AppConstants.FOLLOWER_SERVICE_URL)
	private FetchGitHubFollowersService fetchGitHubFollowersService;
	
	@ApiOperation(value="To fetch GitHubFollowes",notes="Provide userId and Nesting level")
	@RequestMapping(value="gitHubfollowers",method = RequestMethod.GET,produces ={"application/json"})
	public List<FollowerResponse> getFollowers(@RequestParam String userId,
			@RequestParam int depth)
	{
		List<FollowerResponse> resp = fetchGitHubFollowersService.getFollowers(userId,depth);
		for(FollowerResponse r: resp)
		{
			System.out.println(r.getLogin());
		}
		System.out.println(resp.size());
		return resp;
		
	}
	
}
