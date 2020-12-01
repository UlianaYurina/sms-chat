package org.com.chat.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_password")
@NoArgsConstructor
public class UserPassword {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_password")
    private String userPassword;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;

}
