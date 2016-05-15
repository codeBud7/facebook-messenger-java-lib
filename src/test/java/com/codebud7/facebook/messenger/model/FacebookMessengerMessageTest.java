package com.codebud7.facebook.messenger.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by s.puskeiler on 13.05.16.
 */
public class FacebookMessengerMessageTest
{
    @Test
    public void toJson()
    {
        final FacebookMessengerMessage.Builder facebookMessengerMessageBuilder = new FacebookMessengerMessage.Builder();
        facebookMessengerMessageBuilder.withMessage("hello, world!");
        facebookMessengerMessageBuilder.withRecipient(1l);

        final FacebookMessengerMessage objectUnderTest = new FacebookMessengerMessage(facebookMessengerMessageBuilder);

        assertThat(objectUnderTest.toJson(), is("{\"recipient\":{ \"id\":\"1\" }, \"message\":{ \"text\":\"hello, world!\"}}"));
    }
}
