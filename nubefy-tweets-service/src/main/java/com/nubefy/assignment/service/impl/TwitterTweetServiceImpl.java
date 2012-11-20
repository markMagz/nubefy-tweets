package com.nubefy.assignment.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nubefy.assignment.dao.TwitterTweetDao;
import com.nubefy.assignment.model.TwitterTweet;
import com.nubefy.assignment.service.TwitterTweetService;

@Service("twitterTweetService")
public class TwitterTweetServiceImpl implements TwitterTweetService {

    private static final transient Logger _LOG = LoggerFactory.getLogger(TwitterTweetServiceImpl.class);

    @Resource
    private TwitterTweetDao nubefyTweetDao;

    @Override
    public void insertOnlyIfDataDoesNotExist(List<TwitterTweet> nubefyTweets) {
        if (!CollectionUtils.isEmpty(nubefyTweets)) {
            for (TwitterTweet nubefyTweet : nubefyTweets) {
                if (!nubefyTweetDao.ifExist(nubefyTweet)) {
                    _LOG.info("Archiving new tweet {}", nubefyTweet.getText());
                    nubefyTweetDao.create(nubefyTweet);
                }
            }
        }
    }

    @Override
    public List<TwitterTweet> getAll() {
        return nubefyTweetDao.getAll();
    }

}
