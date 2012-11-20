package com.nubefy.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nubefy.assignment.model.TwitterTweet;
import com.nubefy.assignment.service.TwitterTweetService;
import com.nubefy.assignment.twitterapi.client.TwitterApiClient;
import com.nubefy.assignment.twitterapi.client.TwitterGetUserTimelineRequest;
import com.nubefy.assignment.twitterapi.client.TwitterTweetResponse;

@Controller
public class NubefyTweetController {

    private static final transient Logger _LOG = LoggerFactory.getLogger(NubefyTweetController.class);

    @Resource
    private TwitterApiClient twitterApiClient;

    @Resource
    private TwitterTweetService twitterTweetService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @ResponseBody
    @RequestMapping(value = "/tweets/nubefy/archive", method = RequestMethod.POST)
    public String handleRequest() {

        List<TwitterTweetResponse> twitterTweetResponses = null;

        try {
            _LOG.info("Getting latest tweets from Twitter");
            twitterTweetResponses = twitterApiClient.getLatestTweets(new TwitterGetUserTimelineRequest("nubefy", 10));
        } catch (Exception e) {
            _LOG.error("Something when wrong in geting tweets from Twitter", e);
            return "FAILURE";
        }

        List<TwitterTweet> twitterTweets = new ArrayList<TwitterTweet>();

        if (!CollectionUtils.isEmpty(twitterTweetResponses)) {
            for (TwitterTweetResponse twitterTweetResponse : twitterTweetResponses) {
                twitterTweets.add(new TwitterTweet(twitterTweetResponse.getId(), twitterTweetResponse.getTweet()));
            }
        }

        twitterTweetService.insertOnlyIfDataDoesNotExist(twitterTweets);

        return "SUCCESS";
    }
}
