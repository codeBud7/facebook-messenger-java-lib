# facebook-messenger-java-lib
Facebook Messenger Library for Java

# Usage
Implement MessengerProperties interface

*Example:*
```java
@Config.Sources("classpath:messenger.properties")
public interface MessengerProperties extends Config, MessengerProperties
{
    @Key("verify.token")
    @DefaultValue("foo")
    String getVerifyToken();

    @Key("PAGE_ACCESS_TOKEN")
    String getPageAccessToken();

    @Key("api.message.endpoint")
    @DefaultValue("https://graph.facebook.com/v2.6/me/messages")
    String getMessageEndpoint();

    @Key("api.user.endpoint")
    @DefaultValue("https://graph.facebook.com/v2.6/")
    String getUserEndpoint();
}
```

Create controller for verification

*Example:*
```java
    @RequestMapping(value = "/webhook", method = RequestMethod.GET)
    @ResponseBody
    private String verify(
        @RequestParam(name = "hub.mode") final String hubMode,
        @RequestParam(name = "hub.challenge") final String hubChallenge,
        @RequestParam(name = "hub.verify_token") final String hubToken)
    {
        if (hubToken.equals(this.messengerProperties.getVerifyToken()))
        {
            return hubChallenge;
        }
        else
        {
            return NOT_AUTHORIZED;
        }
    }


    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private void receive(@RequestBody final FacebookMessengerCallback facebookMessengerCallback)
    {
        if (FacebookMessengerCallback.FacebookMessengerCallbackType.RECEIVED.equals(facebookMessengerCallback.getType()))
        {
            this.exampleService.sendTextMessage(
                facebookMessengerCallback.getMessageText(),
                facebookMessengerCallback.getSender());
        }
    }
```

Use the FacebookMessengerHandler in your service 

*Example:*
```java
    private FacebookMessengerHandler facebookMessengerHandler;


    public ExampleService()
    {
        this.facebookMessengerHandler = new FacebookMessengerHandlerImpl(ConfigFactory.create(MessengerProperties.class, System.getenv()));
    }


    public void sendTextMessage(final String message, final Long recipientId)
    {
        this.facebookMessengerHandler.sendTextMessage(answer, recipientId);
    }
```

# Todo's:
* integration of token verification
* integration of welcome message
* integrate multiple message types
* push to maven central repo
