package com.nubefy.assignment.dao;

import com.nubefy.assignment.model.TwitterTweet;

public interface TwitterTweetDao extends GenericDao<TwitterTweet, Long> {

    boolean ifExist(TwitterTweet nubefyTweet);
}
