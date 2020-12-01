package org.com.chat.dao;

import org.com.chat.domain.Channel;
import org.com.chat.domain.ChannelDetails;

import java.util.Collection;

public interface ChannelDao {

    Channel createChannel(String name, String displayName);
    Collection<Channel> findAllChannels();
    Channel findChannelByName(String name);
    Channel renameChannels(Integer id, String displayName);
    Channel findChannelById(Integer id);
    Collection<Channel> findChannelByUserId(Integer id);
    ChannelDetails appendDetails(Integer channelId, Integer peopleCount, String description);

}
