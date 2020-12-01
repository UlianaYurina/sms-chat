package org.com.chat;


import org.com.chat.dao.ChannelDao;
import org.com.chat.dao.MessageDao;
import org.com.chat.dao.UserDao;
import org.com.chat.dao.impl.HibernateChannelDao;
import org.com.chat.dao.impl.HibernateMessageDao;
import org.com.chat.dao.impl.HibernateUserDao;
import org.com.chat.domain.Channel;
import org.com.chat.domain.Messages;
import org.com.chat.domain.User;
import org.com.chat.hibernate.HibernateUtils;
import org.com.chat.service.RegistrationService;
import org.com.chat.service.RegistrationServiceImpl;
import org.com.chat.service.SendMessageService;
import org.com.chat.service.SendMessageServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;


public class ChatApplication {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        SendMessageService sendMessageService = new SendMessageServiceImpl();
//        sendMessageService.getChannels(2);
//show dialog
//        MessageDao messageDao = new HibernateMessageDao();
//        List<Messages> messages = messageDao.showMessages(2);
//        for (Messages m : messages) {
//            System.out.println(m.getText() + " " + m.getUser().getId());
//        }



//select channel by user
//        ChannelDao channelDao = new HibernateChannelDao();
//        Collection<Channel> list = channelDao.findChannelByUserId(2);
//        for (Channel c : list) {
//            System.out.println(c.getDisplayName());
//        }


//        RegistrationService registrationService = new RegistrationServiceImpl();
//        User user = registrationService.registrationUser();
//        Channel channel = new Channel();
//        channel.getUsers();
//        System.out.println(channel);




//        ChannelDao channelDao = new HibernateChannelDao();
//create new channel
//        System.out.println("Enter channel name");
//        String name = reader.readLine();
//        System.out.println("Enter display name");
//        String displayName = reader.readLine();
//        Channel channel = channelDao.createChannel(name, displayName);
//        System.out.println(channel);
//
// show all channel
//        Collection<Channel> allChannel = channelDao.findAll();
//        for (Channel ch : allChannel) {
//            System.out.println(ch);
//        }

//find by channelName
//        System.out.println("Enter channel name");
//        String name = reader.readLine();
//        System.out.println(channelDao.findChannelByName(name));

//find by channelId
//        Integer id = Integer.parseInt(reader.readLine());
//        Channel channel = channelDao.findChannelById(id);
//        System.out.println(channel);


//create User
//        UserDao userDao = new HibernateUserDao();
//        String login = reader.readLine();
//        User user = userDao.createUser(login, "one1", "two1", "11111");
//        System.out.println(user);


//remove User By Id
//        UserDao userDao = new HibernateUserDao();
//        User user = userDao.removeUser(Integer.parseInt(reader.readLine()));
//        System.out.println(user);

//append details
//        ChannelDetailsDao channelDetailsDao = new HibernateChannelDetailsDao();
//        Integer a = Integer.parseInt(reader.readLine());
//        Integer b = Integer.parseInt(reader.readLine());
//        String c = reader.readLine();
//
//        channelDetailsDao.appendDetails(a, b, c);

//send Message
//        System.out.println("Enter channel ID:");
//        int channelId = Integer.parseInt(reader.readLine());
//
//        System.out.println("Enter user ID:");
//        int userId = Integer.parseInt(reader.readLine());
//
//        Channel channel = new Channel();
//        channel.setId(channelId);
//
//        User user = new User();
//        user.setId(userId);
//
//        MessageDao messageDao = new HibernateMessageDao();
//
//        System.out.println("Enter message text:");
//        String text = reader.readLine();
//
//        messageDao.sendMessage(user, channel, text);
        



        HibernateUtils.getFactory().close();

    }

}
