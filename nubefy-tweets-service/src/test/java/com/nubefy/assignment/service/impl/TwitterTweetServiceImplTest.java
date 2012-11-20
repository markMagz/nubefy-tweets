package com.nubefy.assignment.service.impl;

import static java.lang.Long.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nubefy.assignment.AbstractTest;
import com.nubefy.assignment.dao.TwitterTweetDao;
import com.nubefy.assignment.model.TwitterTweet;
import com.nubefy.assignment.service.TwitterTweetService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/nubefy-assignment-service-test.xml" })
public class TwitterTweetServiceImplTest extends AbstractTest {

    @Resource
    private TwitterTweetService nubefyTweetService;

    @Resource
    private TwitterTweetDao nubefyTweetDao;

    @Test
    public void shouldInsertDataFromListIntoDatabase() {

        // Given
        List<TwitterTweet> nubefyTweets = Arrays.asList(new TwitterTweet(11L, "tweet 1"), new TwitterTweet(21L,
                "tweet 2"));
        // When
        nubefyTweetService.insertOnlyIfDataDoesNotExist(nubefyTweets);

        // Then

        TwitterTweet twitterTweet1 = nubefyTweetDao.get(11L);
        TwitterTweet twitterTweet2 = nubefyTweetDao.get(21L);
        assertNotNull(twitterTweet1);
        assertNotNull(twitterTweet2);
        assertEquals(twitterTweet1.getId(), valueOf(11));
        assertEquals(twitterTweet1.getText(), "tweet 1");
        assertEquals(twitterTweet2.getId(), valueOf(21));
        assertEquals(twitterTweet2.getText(), "tweet 2");
    }

    @Test
    public void shouldDataFromListIntoDatabase() {

        // Given
        List<TwitterTweet> expected = Arrays.asList(new TwitterTweet(13L, "tweet 1"), new TwitterTweet(32L, "tweet 2"));
        nubefyTweetService.insertOnlyIfDataDoesNotExist(expected);
        // When

        List<TwitterTweet> actual = nubefyTweetService.getAll();
        // Then
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).getId(), actual.get(0).getId());
        assertEquals(expected.get(0).getText(), expected.get(0).getText());
        assertEquals(expected.get(1).getId(), actual.get(1).getId());
        assertEquals(expected.get(1).getText(), expected.get(1).getText());

    }
}
