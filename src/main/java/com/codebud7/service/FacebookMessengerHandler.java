package com.codebud7.service;

import com.codebud7.model.FacebookMessengerUser;
import java.util.Map;

/**
 * Created by s.puskeiler on 09.05.16.
 */
public interface FacebookMessengerHandler
{
    void sendMessage(final String text, final Map<String, Long> recipient);

    FacebookMessengerUser getUserInformation(final Map<String, Long> user);
}
