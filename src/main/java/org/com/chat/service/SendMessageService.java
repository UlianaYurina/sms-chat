package org.com.chat.service;

import org.com.chat.domain.Channel;
import org.com.chat.domain.Messages;
import org.com.chat.domain.User;

import java.io.IOException;

public interface SendMessageService {
    Channel getChannels(User user) throws IOException;
    Messages sendMessage(User user, Channel channel) throws IOException;
}
