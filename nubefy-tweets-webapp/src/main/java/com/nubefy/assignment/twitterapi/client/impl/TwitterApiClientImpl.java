package com.nubefy.assignment.twitterapi.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nubefy.assignment.twitterapi.client.TwitterApiClient;
import com.nubefy.assignment.twitterapi.client.TwitterGetUserTimelineRequest;
import com.nubefy.assignment.twitterapi.client.TwitterTweetResponse;

@Component
public class TwitterApiClientImpl implements TwitterApiClient {

    private static final transient Logger _LOG = LoggerFactory.getLogger(TwitterApiClientImpl.class);

    @Resource
    private HttpClient httpClient;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public List<TwitterTweetResponse> getLatestTweets(TwitterGetUserTimelineRequest request) throws IOException {
        GetMethod getMethod = new GetMethod(TWITTER_USER_TIMELINE_URL);
        getMethod.setQueryString(request.createRequestParams());
        return objectMapper.readValue(webserviceCall(getMethod), new TypeReference<List<TwitterTweetResponse>>() {
        });
    }

    private InputStream webserviceCall(GetMethod getMethod) throws IOException {
        _LOG.info("Retrieving latest tweets from Twitter API");
        httpClient.executeMethod(getMethod);
        return getMethod.getResponseBodyAsStream();
    }
}
