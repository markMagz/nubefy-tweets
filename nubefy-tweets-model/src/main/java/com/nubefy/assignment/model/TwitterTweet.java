package com.nubefy.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TWITTER_TWEETS")
public class TwitterTweet {

    @Id
    @Column(name = "TWITTER_TWEET_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "TWITTER_TWEET_MESSAGE", length = 140)
    private String text;

    public TwitterTweet() {
    }

    public TwitterTweet(Long id, String tweet) {
        this.id = id;
        this.text = tweet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setTextt(String text) {
        this.text = text;
    }
}
