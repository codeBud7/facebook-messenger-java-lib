package com.codebud7.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class FacebookMessengerMessage
{
    private final Map<String, Long> recipient;
    private final Map<String, String> message;


    private FacebookMessengerMessage(final Builder builder)
    {
        this.recipient = builder.recipient;
        this.message = builder.message;
    }


    public static class Builder
    {
        private Map<String, Long> recipient;
        private Map<String, String> message;


        public Builder withMessage(final String message)
        {
            final Map<String, String> messageData = new HashMap<>();
            messageData.put("text", message);

            this.message = messageData;
            return this;
        }


        public Builder withRecipient(final Map<String, Long> recipient)
        {
            this.recipient = recipient;
            return this;
        }


        public FacebookMessengerMessage build()
        {
            return new FacebookMessengerMessage(this);
        }
    }


    public String getRecipient()
    {
        return "'id':'" + this.recipient.get("id") + "'";
    }


    public String getMessage()
    {
        return "'text':'" + this.message.get("text") + "'";
    }


    public String toJson()
    {
        final String stringBuilder = "{'recipient':{"
            + getRecipient()
            + "},'message':{"
            + getMessage()
            + "}}";

        return stringBuilder;
    }
}
