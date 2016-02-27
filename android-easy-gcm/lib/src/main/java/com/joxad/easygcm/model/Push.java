package com.joxad.easygcm.model;

import android.os.Bundle;

/**
 * Push Model
 */
public class Push {

    protected String from;
    protected Bundle data;

    public Push(String from, Bundle data) {
        this.from = from;
        this.data = data;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Bundle getData() {
        return data;
    }

    public void setData(Bundle data) {
        this.data = data;
    }

    public Object getKey(String key) {
        if (data.containsKey(key)) {
            return data.get(key);
        }
        return null;
    }
}

