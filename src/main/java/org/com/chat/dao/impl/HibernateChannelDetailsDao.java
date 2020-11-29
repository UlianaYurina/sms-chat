package org.com.chat.dao.impl;

import org.com.chat.dao.ChannelDetailsDao;
import org.com.chat.domain.Channel;
import org.com.chat.domain.ChannelDetails;
import org.com.chat.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateChannelDetailsDao implements ChannelDetailsDao {

    private final SessionFactory factory;

    public HibernateChannelDetailsDao() {
        this.factory = HibernateUtils.getFactory();
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
