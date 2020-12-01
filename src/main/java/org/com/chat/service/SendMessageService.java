package org.com.chat.service;

import org.com.chat.domain.Channel;
import org.com.chat.domain.Messages;
import org.com.chat.domain.User;

import java.io.IOException;
import java.util.List;

public interface SendMessageService {
    Channel getChannels(User user) throws IOException;
    Messages showMessages(Channel channel);
}
