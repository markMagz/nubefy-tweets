package com.nubefy.assignment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.springframework.transaction.annotation.Transactional;

import com.nubefy.assignment.model.TwitterTweet;

@Transactional
public class AbstractTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {
        entityManager.createQuery("delete from " + TwitterTweet.class.getName()).executeUpdate();
    }
}
