package com.nubefy.assignment.twitterapi.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang.StringUtils;

public class TwitterGetUserTimelineRequest {

    private boolean includeEntities = true;
    private boolean includeRts = true;
    private String screenName;
    private int count;

    public TwitterGetUserTimelineRequest(String screenName, int count) {
        this(screenName, count, true, true);
    }

    public TwitterGetUserTimelineRequest(String screenName, int count, boolean includeEntities, boolean includeRts) {
        this.includeEntities = includeEntities;
        this.includeRts = includeRts;
        this.screenName = screenName;
        this.count = count;
    }

    public boolean isIncludeEntities() {
        return includeEntities;
    }

    public void setIncludeEntities(boolean includeEntities) {
        this.includeEntities = includeEntities;
    }

    public boolean isIncludeRts() {
        return includeRts;
    }

    public void setIncludeRts(boolean includeRts) {
        this.includeRts = includeRts;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public NameValuePair[] createRequestParams() {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("include_entities", String.valueOf(includeEntities)));
        params.add(new NameValuePair("include_rts", String.valueOf(includeRts)));

        if (StringUtils.isNotBlank(screenName)) {
            params.add(new NameValuePair("screen_name", screenName));
        }
        if (count != 0) {
            params.add(new NameValuePair("count", String.valueOf(count)));
        }
        return params.toArray(new NameValuePair[] {});
    }
}
