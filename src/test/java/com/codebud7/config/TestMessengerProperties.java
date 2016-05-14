package com.codebud7.config;

/**
 * Created by s.puskeiler on 13.05.16.
 */
public class TestMessengerProperties implements MessengerProperties
{
    @Override
    public String getVerifyToken()
    {
        return "foo";
    }


    @Override
    public String getPageAccessToken()
    {
        return "";
    }


    @Override
    public String getMessageEndpoint()
    {
        return "https://graph.facebook.com/v2.6/me/messages";
    }


    @Override
    public String getUserEndpoint()
    {
        return "https://graph.facebook.com/v2.6/";
    }
}
