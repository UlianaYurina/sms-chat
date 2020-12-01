package org.com.chat.dao.impl;

import org.com.chat.dao.ChannelDao;
import org.com.chat.domain.Channel;
import org.com.chat.domain.ChannelDetails;
import org.com.chat.domain.User;
import org.com.chat.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class HibernateChannelDao implements ChannelDao {

    private final SessionFactory factory;

    public HibernateChannelDao() {
        this.factory = HibernateUtils.getFactory();
    }

    @Override
    public Channel createChannel(String name, String displayName) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Channel channel = new Channel();
        channel.setName(name);
        channel.setDisplayName(displayName);

        session.persist(channel);

        transaction.commit();
        session.close();

        return channel;
    }

    @Override
    public Collection<Channel> findAllChannels() {
        try (Session session = factory.openSession()){
            Collection<Channel> allChannels = session.createQuery("from Channel", Channel.class).getResultList();

            return allChannels;
        }
    }

    @Override
    public Channel findChannelByName(String name) {
        try (Session session = factory.openSession()) {
            List<Channel> channels = session
                    .createQuery("from Channel where name = :n", Channel.class)
                    .setParameter("n", name)
                    .getResultList();
            return channels.isEmpty() ? null : channels.get(0);
        }
    }

    @Override
    public Channel renameChannels(Integer id, String displayName) {
        try (Session session = factory.openSession()){
            Transaction transaction = session.beginTransaction();

            Channel channel = session.get(Channel.class, id);

            channel.setId(channel.getId());
            channel.setName(channel.getName());
            channel.setDisplayName(displayName);

            session.update(channel);

            transaction.commit();

            System.out.println("Channel was updated");

            return channel;
        }
    }

    @Override
    public Channel findChannelById(Integer id) {
        try (Session session = factory.openSession()) {
            return session.get(Channel.class, id);
        }
    }

    @Override
    public Collection<Channel> findChannelByUserId(Integer user_id) {
        try (Session session = factory.openSession()) {
            User user = session
                    .createQuery("from User  where id = :id", User.class)
                    .setParameter("id", user_id)
                    .getSingleResult();

            List<Channel> channels = session
                    .createQuery("select c from  Channel c join c.users u where u.id = :u", Channel.class)
                    .setParameter("u", user.getId())
                    .getResultList();
            return channels.isEmpty() ? null : channels;
        }

    }

    @Override
    public ChannelDetails appendDetails(Integer channelId, Integer peopleCount, String description) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Channel channel = session.get(Channel.class, channelId);
            ChannelDetails channelDetails = new ChannelDetails();

            channelDetails.setChannelId(channelId);
            channelDetails.setChannel(channel);

            channelDetails.setPeopleCount(peopleCount);
            channelDetails.setDescription(description);


            session.persist(channelDetails);
            transaction.commit();

            return channelDetails;

        }
    }
}
