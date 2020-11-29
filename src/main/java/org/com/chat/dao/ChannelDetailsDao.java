package org.com.chat.dao;

import org.com.chat.domain.ChannelDetails;

public interface ChannelDetailsDao {

    ChannelDetails appendDetails(Integer channelId, Integer peopleCount, String description);
}
