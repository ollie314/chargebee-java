/*
 * Copyright (c) 2012 chargebee.com
 * All Rights Reserved.
 */
package com.chargebee.models;

import com.chargebee.*;
import com.chargebee.internal.*;
import com.chargebee.internal.HttpUtil.Method;
import com.chargebee.models.enums.*;
import org.json.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

public class Event extends Resource<Event> {

    public enum WebhookStatus {
        NOT_CONFIGURED,
        SCHEDULED,
        SUCCEEDED,
        RE_SCHEDULED,
        FAILED,
        _UNKNOWN; /*Indicates unexpected value for this enum. You can get this when there is a 
        java-client version incompatibility. We suggest you to upgrade to the latest version */
    }

    //Constructors
    //============

    public Event(InputStream is) throws IOException {
        super(is);
    }
    
    public Event(BufferedReader rd) throws IOException {
        super(rd);
    }

    public Event(String jsonStr) {
        super(jsonStr);
    }
    
    public Event(JSONObject jsonObj) {
        super(jsonObj);
    }

    // Fields
    //=======

    public String id() {
        return reqString("id");
    }

    public Timestamp occurredAt() {
        return optTimestamp("occurred_at");
    }

    public WebhookStatus webhookStatus() {
        return reqEnum("webhook_status", WebhookStatus.class);
    }

    public String webhookFailureReason() {
        return optString("webhook_failure_reason");
    }

    public EventType eventType() {
        return optEnum("event_type", EventType.class);
    }

    // Operations
    //===========

    public static ListRequest list() throws IOException {
        String url = url("events");
        return new ListRequest(url);
    }

    public static Request retrieve(String id) throws IOException {
        String url = url("events", nullCheck(id));
        return new Request(Method.GET, url);
    }

    public static class Content extends ResultBase{

        public Content(JSONObject jsonObj) {
            super(jsonObj);
        }
    }

    public Content content(){
        return new Content(optJSONObject("content"));
    }
}
