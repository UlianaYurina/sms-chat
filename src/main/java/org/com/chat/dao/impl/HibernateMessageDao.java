package org.com.chat.dao.impl;

import org.com.chat.dao.MessageDao;
import org.com.chat.domain.Channel;
import org.com.chat.domain.Messages;
import org.com.chat.domain.User;
import org.com.chat.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;


public class HibernateMessageDao implements MessageDao {

    private final SessionFactory factory;

    public HibernateMessageDao() {
        this.factory = HibernateUtils.getFactory();
    }

    @Override
    public Messages sendMessage(User user, Channel channel, String text) {
        try (Session session = factory.openSession()){
            Transaction transaction = session.beginTransaction();

            Messages messages = new Messages();

            messages.setChannel(channel);
            messages.setUser(user);
            messages.setText(text);
            messages.setDate(new Date());

            session.persist(messages);

            transaction.commit();

            return messages;
        }

    }
}
