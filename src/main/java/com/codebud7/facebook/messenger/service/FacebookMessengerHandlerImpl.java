package com.codebud7.facebook.messenger.service;

import com.codebud7.facebook.messenger.config.MessengerProperties;
import com.codebud7.facebook.messenger.model.FacebookMessengerMessage;
import com.codebud7.facebook.messenger.model.FacebookMessengerUser;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by s.puskeiler on 09.05.16.
 */
class FacebookMessengerHandlerImpl implements FacebookMessengerHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FacebookMessengerHandler.class);

    private final static String ACCESS_TOKEN = "access_token";
    private final static String FIELDS_HEADER = "fields";
    private final static String USER_DATA = "fields=first_name,last_name,profile_pic,locale,timezone,gender&amp;";

    private final MessengerProperties messengerProperties;


    FacebookMessengerHandlerImpl(final MessengerProperties messengerProperties)
    {
        this.messengerProperties = messengerProperties;
    }


    public Boolean validateToken(final String verifyToken)
    {
        return this.messengerProperties.getVerifyToken().equals(verifyToken);
    }


    public void setWelcomeMessage(final String welcomeMessage)
    {
        throw new NotImplementedException();
    }


    public void sendTextMessage(final String textMessage, final Long recipientId)
    {
        final FacebookMessengerMessage facebookMessengerMessage = new FacebookMessengerMessage.Builder()
            .withMessage(textMessage)
            .withRecipient(recipientId)
            .build();

        try
        {
            final Headers headers = Unirest.post(this.messengerProperties.getMessageEndpoint())
                .header("Content-Type", "application/json")
                .queryString(ACCESS_TOKEN, this.messengerProperties.getPageAccessToken())
                .body(facebookMessengerMessage.toJson())
                .asJson()
                .getHeaders();

            LOGGER.debug(headers.toString());
        }
        catch (final UnirestException e)
        {
            LOGGER.error(e.toString());
        }
    }


    public FacebookMessengerUser getUserProfile(final Long user)
    {
        try
        {
            final HttpResponse<FacebookMessengerUser> httpResponse = Unirest.post(this.messengerProperties.getUserEndpoint() + user)
                .header("Content-Type", "application/json")
                .queryString(FIELDS_HEADER, USER_DATA)
                .queryString(ACCESS_TOKEN, this.messengerProperties.getPageAccessToken())
                .asObject(FacebookMessengerUser.class);

            return httpResponse.getBody();
        }
        catch (final UnirestException e)
        {
            LOGGER.error(e.toString());
        }

        return null;
    }
}
