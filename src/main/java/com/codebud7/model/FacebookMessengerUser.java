package com.codebud7.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class FacebookMessengerUser
{
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("profile_pic")
    private String profilePic;
    private String locale;
    private String timezone;
    private String gender;


    public String getFirstName()
    {
        return this.firstName;
    }


    public FacebookMessengerUser setFirstName(final String firstName)
    {
        this.firstName = firstName;
        return this;
    }


    public String getLastName()
    {
        return this.lastName;
    }


    public FacebookMessengerUser setLastName(final String lastName)
    {
        this.lastName = lastName;
        return this;
    }


    public String getProfilePic()
    {
        return this.profilePic;
    }


    public FacebookMessengerUser setProfilePic(final String profilePic)
    {
        this.profilePic = profilePic;
        return this;
    }


    public String getLocale()
    {
        return this.locale;
    }


    public FacebookMessengerUser setLocale(final String locale)
    {
        this.locale = locale;
        return this;
    }


    public String getTimezone()
    {
        return this.timezone;
    }


    public FacebookMessengerUser setTimezone(final String timezone)
    {
        this.timezone = timezone;
        return this;
    }


    public String getGender()
    {
        return this.gender;
    }


    public FacebookMessengerUser setGender(final String gender)
    {
        this.gender = gender;
        return this;
    }
}
