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
import java.util.List;


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

    @Override
    public List<Messages> showMessages(Channel channel) {

        try (Session session = factory.openSession()) {
            List<Messages> messages = session
                    .createQuery("from Messages m where m.channel.id = :channel_id", Messages.class)
                    .setParameter("channel_id", channel.getId())
                    .getResultList();

//            List<Messages> messages = session
//                    .createQuery("from Messages m where m.channel.id = :channel_id and m.user.id =: user_id", Messages.class)
//                    .setParameter("channel_id", channel_id)
//                    .setParameter("user_id", user_id)
//                    .getResultList();
            return messages;
        }
    }
}
