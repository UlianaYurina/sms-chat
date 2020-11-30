package org.com.chat.dao;

import org.com.chat.domain.Channel;
import org.com.chat.domain.Messages;
import org.com.chat.domain.User;

public interface MessageDao {
    Messages sendMessage(User user, Channel channel, String text);
}
