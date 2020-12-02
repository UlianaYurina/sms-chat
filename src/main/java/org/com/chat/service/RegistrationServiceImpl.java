package org.com.chat.service;

import org.com.chat.dao.UserDao;
import org.com.chat.dao.impl.HibernateUserDao;
import org.com.chat.domain.User;
import org.com.chat.domain.UserPassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RegistrationServiceImpl implements RegistrationService {


    @Override
    public User registrationUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your login: ");
        String login = reader.readLine();

        UserDao userDao = new HibernateUserDao();
        User user = userDao.findUserByLogin(login);

        if (user == null) {
            System.out.println("User is not exist. Do you want to create a new user? Enter y");
            if (reader.readLine().equals("y")) {

                NewUserService newUserService = new NewUserServiceImpl();

                user = newUserService.newUser(login);

            } else
                return null;
        }

        System.out.println("Enter your password: ");
        String password = reader.readLine();

        UserPassword userPassword = userDao.findPassword(user.getId());

        if (!password.equals(userPassword.getUserPassword())) {
            while (!password.equals(userPassword.getUserPassword())) {
                System.out.println("Bad password. Try again? Enter y");
                if (reader.readLine().equals("y")) {
                    System.out.println("Enter your password: ");
                    password = reader.readLine();
                } else
                    return null;
            }
        }

        return user;

   }
}