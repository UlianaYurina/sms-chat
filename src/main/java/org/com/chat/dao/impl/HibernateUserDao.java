package org.com.chat.dao.impl;

import org.com.chat.dao.UserDao;
import org.com.chat.domain.Channel;
import org.com.chat.domain.User;
import org.com.chat.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class HibernateUserDao implements UserDao {

    private final SessionFactory factory;

    public HibernateUserDao() {
        this.factory = HibernateUtils.getFactory();
    }


    @Override
    public User createUser(String login, String firstName, String lastName) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();

        user.setLogin(login);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        session.persist(user);
        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public Collection<User> findAllUsers() {
        try (Session session = factory.openSession()){
            return session.createQuery("from User", User.class).getResultList();
        }
    }

    @Override
    public User findUserByLogin(String login) {
        try (Session session = factory.openSession()) {
            List<User> user = session
                    .createQuery("from User where login = :log", User.class)
                    .setParameter("log", login)
                    .getResultList();
            return user.isEmpty() ? null : user.get(0);
        }
    }

    @Override
    public User removeUser(Integer id) {

        try (Session session = factory.openSession()){
            Transaction transaction = session.beginTransaction();

            Query query = session
                    .createQuery("delete from User where id = :user_id")
                    .setParameter("user_id", id);
            query.executeUpdate();

            transaction.commit();
        }

        return null;
    }
}
