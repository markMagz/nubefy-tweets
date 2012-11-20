package com.nubefy.assignment.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;
import javax.persistence.EntityExistsException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nubefy.assignment.AbstractTest;
import com.nubefy.assignment.dao.TwitterTweetDao;
import com.nubefy.assignment.model.TwitterTweet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/nubefy-assignment-service-test.xml" })
public class TwitterTweetDaoImplTest extends AbstractTest {

    @Resource
    private TwitterTweetDao nubefyTweetDao;

    @Test
    public void shouldInsertDataInDatabase() {
        // Given /When
        nubefyTweetDao.create(new TwitterTweet(1L, "Hello World!"));
        // Then
        assertNotNull(nubefyTweetDao.get(1L));
    }

    @Test(expected = EntityExistsException.class)
    public void shouldThrowDataIntegrityViolationExceptionWhenInsertingDataWithExistingId() {
        // Given /When
        nubefyTweetDao.create(new TwitterTweet(2L, "You Tweet!"));

        // Then insert with 1L id again
        nubefyTweetDao.create(new TwitterTweet(2L, "Nyahahah!"));
    }

    @Test
    public void shouldReturnDataFromDatabaseWhenRecordExistWithId() {
        // Given
        nubefyTweetDao.create(new TwitterTweet(3L, "get Test!"));

        // When
        TwitterTweet nubefyTweet = nubefyTweetDao.get(3L);

        // Then
        assertEquals(nubefyTweet.getText(), "get Test!");
    }

    @Test
    public void shouldReturnNullFromDatabaseWhenRecordDoesNotExist() {
        // Given /When / Then
        assertNull(nubefyTweetDao.get(10L));
    }

    @Test
    public void shouldReturnTrueFromDatabaseWhenRecordExistWithId() {
        // Given
        nubefyTweetDao.create(new TwitterTweet(4L, "get Test!"));

        // When /Then
        assertTrue(nubefyTweetDao.ifExist(new TwitterTweet(4L, "get Test!")));

    }

    @Test
    public void shouldReturnFalseFromDatabaseWhenRecordDoesNotExist() {
        // Given /When / Then
        assertFalse(nubefyTweetDao.ifExist(new TwitterTweet(10L, "get Test!")));
    }

}
