package com.codebud7.service;

import com.codebud7.model.FacebookMessengerUser;

/**
 * Created by s.puskeiler on 09.05.16.
 */
public interface FacebookMessengerHandler
{
    void setWelcomeMessage(final String welcomeMessage);

    void sendTextMessage(final String textMessage, final Long recipientId);

    FacebookMessengerUser getUserProfile(final Long user);
}
