package org.com.chat.service;

import org.com.chat.dao.ChannelDao;
import org.com.chat.dao.MessageDao;
import org.com.chat.dao.impl.HibernateChannelDao;
import org.com.chat.dao.impl.HibernateMessageDao;
import org.com.chat.domain.Channel;
import org.com.chat.domain.Messages;
import org.com.chat.domain.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

public class SendMessageServiceImpl implements SendMessageService {

    @Override
    public Channel getChannels(User user) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ChannelDao channelDao = new HibernateChannelDao();
        Collection<Channel> channels = channelDao.findChannelByUserId(user.getId());
        for (Channel c : channels) {
            System.out.println(c.getId() + "--->" + c.getDisplayName());
        }


        Channel channel;
        while (true) {
            System.out.println("Enter number of channel:");
            String channelId = reader.readLine();
            for (Channel c : channels) {
                if (c.getId().equals(Integer.parseInt(channelId))) {
                    channel = c;
                    return channel;

                }
            }
            System.out.println("Bad channel(( Try again. ");
        }
    }

    @Override
    public Messages showMessages(Channel channel) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MessageDao messageDao = new HibernateMessageDao();
        List<Messages> messages = messageDao.showMessages(channel);
        for (Messages m : messages) {
            System.out.println(m.getUser().getFirstName() + "  -  " + m.getText());
        }

        return null;
    }
}
