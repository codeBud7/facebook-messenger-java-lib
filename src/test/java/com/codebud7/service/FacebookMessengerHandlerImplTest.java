package com.codebud7.service;

import com.codebud7.config.TestMessengerProperties;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by s.puskeiler on 13.05.16.
 */
public class FacebookMessengerHandlerImplTest
{
    private FacebookMessengerHandler objectUnderTest = new FacebookMessengerHandlerImpl(new TestMessengerProperties());


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
