package org.com.chat;

import org.com.chat.dao.ChannelDao;
import org.com.chat.dao.ChannelDetailsDao;
import org.com.chat.dao.UserDao;
import org.com.chat.dao.impl.HibernateChannelDao;
import org.com.chat.dao.impl.HibernateChannelDetailsDao;
import org.com.chat.dao.impl.HibernateUserDao;
import org.com.chat.domain.Channel;
import org.com.chat.domain.User;
import org.com.chat.hibernate.HibernateUtils;
import org.hibernate.Hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class ChatApplication {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


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

//        UserDao userDao = new HibernateUserDao();
//remove User By Id
//        User user = userDao.removeUser(Integer.parseInt(reader.readLine()));
//        System.out.println(user);

//append details
        ChannelDetailsDao channelDetailsDao = new HibernateChannelDetailsDao();
        Integer a = Integer.parseInt(reader.readLine());
        Integer b = Integer.parseInt(reader.readLine());
        String c = reader.readLine();

        channelDetailsDao.appendDetails(a, b, c);

        



        HibernateUtils.getFactory().close();

    }

}
