package com.codebud7.model;

import java.util.List;
import java.util.Map;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class FacebookMessengerCallback
{
    private String object;
    private List<Entry> entry;


    public FacebookMessengerCallback()
    {
    }


    public String getObject()
    {
        return this.object;
    }


    public void setObject(final String object)
    {
        this.object = object;
    }


    public List<Entry> getEntry()
    {
        return this.entry;
    }


    public void setEntry(final List<Entry> entry)
    {
        this.entry = entry;
    }


    @Override
    public String toString()
    {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("object:").append(getObject());
        for (final Entry entry : getEntry())
        {
            stringBuilder.append("id:").append(entry.getId());
            stringBuilder.append("time:").append(entry.getTime());
            for (final Entry.Messaging facebookMessengerMessage : entry.getMessaging())
            {
                stringBuilder.append("recipient:").append(facebookMessengerMessage.getRecipient());
                stringBuilder.append("sender:").append(facebookMessengerMessage.getSender());
                stringBuilder.append("timestamp:").append(facebookMessengerMessage.getTimestamp());

                final Entry.Messaging.Message messengerBotEntryMessagingMessage = facebookMessengerMessage.getMessage();
                if (messengerBotEntryMessagingMessage != null)
                {
                    if (messengerBotEntryMessagingMessage.getMid() != null)
                    {
                        stringBuilder.append("mid:").append(messengerBotEntryMessagingMessage.getMid());
                    }
                    if (messengerBotEntryMessagingMessage.getSeq() != null)
                    {
                        stringBuilder.append("seq:").append(messengerBotEntryMessagingMessage.getSeq());
                    }
                    if (messengerBotEntryMessagingMessage.getText() != null)
                    {
                        stringBuilder.append("text:").append(messengerBotEntryMessagingMessage.getText());
                    }
                }

                final Entry.Messaging.Delivery messengerBotEntryDeliveredMessage = facebookMessengerMessage.getDelivery();
                if (messengerBotEntryDeliveredMessage != null)
                {
                    if (messengerBotEntryDeliveredMessage.getMids() != null)
                    {
                        stringBuilder.append("mid:").append(messengerBotEntryDeliveredMessage.getMids());
                    }
                    if (messengerBotEntryDeliveredMessage.getSeq() != null)
                    {
                        stringBuilder.append("seq:").append(messengerBotEntryDeliveredMessage.getSeq());
                    }
                    if (messengerBotEntryDeliveredMessage.getWatermark() != null)
                    {
                        stringBuilder.append("watermark:").append(messengerBotEntryDeliveredMessage.getWatermark());
                    }
                }

            }
        }

        return stringBuilder.toString();
    }


    public FacebookMessengerCallbackType getType()
    {
        final List<Entry> entryList = this.getEntry();
        if (!entryList.isEmpty())
        {
            final Entry entry = entryList.get(0);
            if (entry != null && entry.getMessaging() != null)
            {
                final List<Entry.Messaging> messagingList = entry.getMessaging();
                if (!messagingList.isEmpty())
                {
                    final Entry.Messaging messaging = messagingList.get(0);
                    if (messaging != null)
                    {
                        if (messaging.getMessage() != null)
                        {
                            return FacebookMessengerCallbackType.RECEIVED;
                        }
                        else if (messaging.getDelivery() != null)
                        {
                            return FacebookMessengerCallbackType.DELIVERED;
                        }
                    }
                }
            }
        }

        return FacebookMessengerCallbackType.UNKNOWN;
    }


    public Map<String, Long> getSender()
    {
        final List<Entry> entryList = this.getEntry();
        if (!entryList.isEmpty())
        {
            final Entry entry = entryList.get(0);
            if (entry != null && entry.getMessaging() != null)
            {
                final List<Entry.Messaging> messagingList = entry.getMessaging();
                if (!messagingList.isEmpty())
                {
                    final Entry.Messaging messaging = messagingList.get(0);
                    if (messaging != null)
                    {
                        if (messaging.getMessage() != null)
                        {
                            return messaging.getSender();
                        }
                    }
                }
            }
        }

        return null;
    }


    public String getMessageText()
    {
        final List<Entry> entryList = this.getEntry();
        if (!entryList.isEmpty())
        {
            final Entry entry = entryList.get(0);
            if (entry != null && entry.getMessaging() != null)
            {
                final List<Entry.Messaging> messagingList = entry.getMessaging();
                if (!messagingList.isEmpty())
                {
                    final Entry.Messaging messaging = messagingList.get(0);
                    if (messaging != null)
                    {
                        if (messaging.getMessage() != null)
                        {
                            return messaging.getMessage().getText();
                        }
                    }
                }
            }
        }

        return null;
    }

    public static class Entry
    {
        private Long id;
        private Long time;
        private List<Messaging> messaging;


        public Entry()
        {
        }


        Long getId()
        {
            return this.id;
        }


        public Entry setId(final Long id)
        {
            this.id = id;
            return this;
        }


        public Long getTime()
        {
            return this.time;
        }


        public Entry setTime(final Long time)
        {
            this.time = time;
            return this;
        }


        public List<Messaging> getMessaging()
        {
            return this.messaging;
        }


        public Entry setMessaging(final List<Messaging> messaging)
        {
            this.messaging = messaging;
            return this;
        }


        public static class Messaging
        {
            private Map<String, Long> sender;
            private Map<String, Long> recipient;
            private Long timestamp;
            private Message message;
            private Delivery delivery;


            public Messaging()
            {
            }


            public Map<String, Long> getSender()
            {
                return this.sender;
            }


            public Messaging setSender(final Map<String, Long> sender)
            {
                this.sender = sender;
                return this;
            }


            public Map<String, Long> getRecipient()
            {
                return this.recipient;
            }


            public Messaging setRecipient(final Map<String, Long> recipient)
            {
                this.recipient = recipient;
                return this;
            }


            public Long getTimestamp()
            {
                return this.timestamp;
            }


            public Messaging setTimestamp(final Long timestamp)
            {
                this.timestamp = timestamp;
                return this;
            }


            public Message getMessage()
            {
                return this.message;
            }


            public Messaging setMessage(final Message message)
            {
                this.message = message;
                return this;
            }


            public Delivery getDelivery()
            {
                return this.delivery;
            }


            public Messaging setDelivery(final Delivery delivery)
            {
                this.delivery = delivery;
                return this;
            }


            private static class Delivery
            {
                private List<String> mids;
                private Long watermark;
                private Long seq;


                public Delivery()
                {
                }


                public List<String> getMids()
                {
                    return this.mids;
                }


                public Delivery setMids(final List<String> mids)
                {
                    this.mids = mids;
                    return this;
                }


                public Long getWatermark()
                {
                    return this.watermark;
                }


                public Delivery setWatermark(final Long watermark)
                {
                    this.watermark = watermark;
                    return this;
                }


                public Long getSeq()
                {
                    return this.seq;
                }


                public Delivery setSeq(final Long seq)
                {
                    this.seq = seq;
                    return this;
                }
            }

            private static class Message
            {
                private String mid;
                private Long seq;
                private String text;


                public Message()
                {
                }


                public String getMid()
                {
                    return this.mid;
                }


                public Message setMid(final String mid)
                {
                    this.mid = mid;
                    return this;
                }


                public Long getSeq()
                {
                    return this.seq;
                }


                public Message setSeq(final Long seq)
                {
                    this.seq = seq;
                    return this;
                }


                public String getText()
                {
                    return this.text;
                }


                public Message setText(final String text)
                {
                    this.text = text;
                    return this;
                }
            }
        }
    }

    public enum FacebookMessengerCallbackType
    {
        DELIVERED,
        RECEIVED,
        UNKNOWN
    }
}
