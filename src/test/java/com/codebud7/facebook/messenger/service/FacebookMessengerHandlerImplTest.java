package com.codebud7.facebook.messenger.service;

import com.codebud7.facebook.messenger.config.TestMessengerProperties;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by s.puskeiler on 13.05.16.
 */
public class FacebookMessengerHandlerImplTest
{
    private FacebookMessengerHandler objectUnderTest = new FacebookMessengerHandlerImpl(new TestMessengerProperties());


    @Test
    public void validateToken()
    {
        final Boolean validateToken = this.objectUnderTest.validateToken("foo");
        assertThat(validateToken, is(true));
    }


    @Test(expected = NotImplementedException.class)
    public void setWelcomeMessage()
    {
        this.objectUnderTest.setWelcomeMessage("welcome");
    }


    @Test
    public void sendTextMessage()
    {
        this.objectUnderTest.sendTextMessage("", 1l);
    }


    @Test
    public void getUserProfile()
    {
        this.objectUnderTest.getUserProfile(null);
    }
}
