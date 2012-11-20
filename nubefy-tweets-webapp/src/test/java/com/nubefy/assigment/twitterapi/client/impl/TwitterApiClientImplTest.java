package com.nubefy.assigment.twitterapi.client.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nubefy.assignment.twitterapi.client.TwitterApiClient;
import com.nubefy.assignment.twitterapi.client.TwitterGetUserTimelineRequest;
import com.nubefy.assignment.twitterapi.client.TwitterTweetResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/nubefy-assignment-webapp-test.xml" })
public class TwitterApiClientImplTest {

    @Resource
    private TwitterApiClient twitterApiClient;

    @Test
    public void shouldGetLatestTweets() throws IOException {
        // Given /When
        List<TwitterTweetResponse> twitterTweetBeans = twitterApiClient
                .getLatestTweets(new TwitterGetUserTimelineRequest("markMagallanes", 5));

        // Then
        assertFalse(twitterTweetBeans.isEmpty());
        assertEquals(twitterTweetBeans.size(), 5);
    }
}
