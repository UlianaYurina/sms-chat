package org.com.chat.dao;

import org.com.chat.domain.Channel;
import org.com.chat.domain.Messages;
import org.com.chat.domain.User;

import java.util.List;

public interface MessageDao {
    Messages sendMessage(User user, Channel channel, String text);
    List<Messages> showMessages(Channel channel);
}
