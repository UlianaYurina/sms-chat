package org.com.chat.service;

import org.com.chat.domain.User;

import java.io.IOException;

public interface NewUserService {

    User newUser(String loginNew) throws IOException;

}
