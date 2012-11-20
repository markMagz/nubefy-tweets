package com.nubefy.assignment.dao.impl;

import org.springframework.stereotype.Repository;

import com.nubefy.assignment.dao.TwitterTweetDao;
import com.nubefy.assignment.model.TwitterTweet;

@Repository("twitterTweetDao")
public class TwitterTweetDaoImpl extends GenericDaoImpl<TwitterTweet, Long> implements TwitterTweetDao {

    public TwitterTweetDaoImpl() {
        super(TwitterTweet.class);
    }

    @Override
    public boolean ifExist(TwitterTweet nubefyTweet) {
        return get(nubefyTweet.getId()) != null;
    }

}
