package org.com.chat.service;

import org.com.chat.domain.User;

import java.io.IOException;

public interface RegistrationService {
    User registrationUser() throws IOException;
}
