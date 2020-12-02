package org.com.chat.hibernate;

import org.com.chat.domain.Channel;
import org.com.chat.domain.ChannelDetails;
import org.com.chat.domain.Messages;
import org.com.chat.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

class HibernateUtilsTest {

    private static SessionFactory testFactory;

    private HibernateUtilsTest() {

    }

    static {

        Properties databaseProperties = new Properties();

        databaseProperties.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        databaseProperties.setProperty("hibernate.connection.url", "jdbc:h2:mem:chat;INIT=CREATE SCHEMA IF NOT EXISTS chat");
        databaseProperties.setProperty("hibernate.connection.username", "sa");
        databaseProperties.setProperty("hibernate.connection.password", "");
        databaseProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        databaseProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        databaseProperties.setProperty("hibernate.show_sql", "true");
        databaseProperties.setProperty("hibernate.format_sql", "true");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(databaseProperties)
                .build();

        testFactory = new Configuration()
                .addAnnotatedClass(Channel.class)
                .addAnnotatedClass(ChannelDetails.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Messages.class)
                .buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory() {
        return testFactory;
    }

}