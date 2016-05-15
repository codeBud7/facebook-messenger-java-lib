package com.codebud7.facebook.messenger.config;

/**
 * Created by s.puskeiler on 09.05.16.
 */
public interface MessengerProperties
{
    String getVerifyToken();

    String getPageAccessToken();

    String getMessageEndpoint();

    String getUserEndpoint();
}
