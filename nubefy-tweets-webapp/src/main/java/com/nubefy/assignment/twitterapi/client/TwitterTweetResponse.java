package com.nubefy.assignment.twitterapi.client;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterTweetResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("text")
    private String tweet;

    public TwitterTweetResponse() {
    }

    public TwitterTweetResponse(Long id, String tweet) {
        this.id = id;
        this.tweet = tweet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
