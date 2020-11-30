package org.com.chat.dao;

import org.com.chat.dao.impl.HibernateChannelDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ChannelDaoTest {

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    @InjectMocks
    private HibernateChannelDao dao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(factory.openSession()).thenReturn(session);
        Mockito.when(session.beginTransaction()).thenReturn(transaction);
    }


    @Test
    void createChannel() {
    }

    @Test
    void findAllChannels() {
    }

    @Test
    void findChannelByName() {
    }

    @Test
    void renameChannels() {
    }

    @Test
    void findChannelById() {
    }
}