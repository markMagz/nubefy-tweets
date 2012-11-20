package com.nubefy.assignment.service;

import java.util.List;

import com.nubefy.assignment.model.TwitterTweet;

public interface TwitterTweetService {

    void insertOnlyIfDataDoesNotExist(List<TwitterTweet> nubefyTweets);

    List<TwitterTweet> getAll();
}
