package com.codebud7.facebook.messenger.service;

import com.codebud7.facebook.messenger.model.FacebookMessengerUser;

/**
 * Created by s.puskeiler on 09.05.16.
 */
public interface FacebookMessengerHandler
{
    void setWelcomeMessage(final String welcomeMessage);

    void sendTextMessage(final String textMessage, final Long recipientId);

    FacebookMessengerUser getUserProfile(final Long user);
}
