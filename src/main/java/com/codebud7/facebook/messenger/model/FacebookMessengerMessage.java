package com.codebud7.facebook.messenger.model;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class FacebookMessengerMessage
{
    private final Recipient recipient;
    private final Text message;


    FacebookMessengerMessage(final Builder builder)
    {
        this.recipient = builder.recipient;
        this.message = builder.message;
    }


    public static class Builder
    {
        private Recipient recipient;
        private Text message;


        public Builder withMessage(final String message)
        {
            this.message = new Text(message);
            return this;
        }


        public Builder withRecipient(final Long recipient)
        {
            this.recipient = new Recipient(recipient.toString());
            return this;
        }


        public FacebookMessengerMessage build()
        {
            return new FacebookMessengerMessage(this);
        }
    }


    private Recipient getRecipient()
    {
        return this.recipient;
    }


    private Text getMessage()
    {
        return this.message;
    }


    public String toJson()
    {
        return "{\"recipient\":{ \"id\":\""
            + getRecipient().getId()
            + "\" }, \"message\":{ \"text\":\""
            + getMessage().getText()
            + "\"}}";
    }


    private static class Text
    {
        private String text;


        Text(final String text)
        {
            this.text = text;
        }


        public String getText()
        {
            return this.text;
        }


        public Text setText(final String text)
        {
            this.text = text;
            return this;
        }
    }

    private static class Recipient
    {
        private String id;


        Recipient(final String id)
        {
            this.id = id;
        }


        public String getId()
        {
            return this.id;
        }


        public Recipient setId(final String id)
        {
            this.id = id;
            return this;
        }
    }
}
