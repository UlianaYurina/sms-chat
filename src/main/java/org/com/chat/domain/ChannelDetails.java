package org.com.chat.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "channel_details")
@NoArgsConstructor
public class ChannelDetails {

    @Id
    @Column(name = "channel_id")
    private Integer channelId;

    @Column(name = "people_count")
    private Integer peopleCount;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

}
