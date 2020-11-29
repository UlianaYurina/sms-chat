package org.com.chat.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name = "channel")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "display_name", nullable = false, unique = false, length = 100)
    private String displayName;

    @OneToOne(mappedBy = "channel")
    private ChannelDetails channelDetails;

    @OneToMany(mappedBy = "channel")
    private Collection<Messages> messages;

    @ManyToMany
    @JoinTable(name = "user_channels",
                joinColumns = @JoinColumn(name = "channel_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Collection<User> users;


}
