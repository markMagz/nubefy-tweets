package com.nubefy.assignment.twitterapi.client;

import java.io.IOException;
import java.util.List;

public interface TwitterApiClient {

    String TWITTER_USER_TIMELINE_URL = "https://api.twitter.com/1/statuses/user_timeline.json";

    List<TwitterTweetResponse> getLatestTweets(TwitterGetUserTimelineRequest request) throws IOException;
}
