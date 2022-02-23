package com.hedgehog.user_api.service;

import com.hedgehog.user_api.model.User;
import java.util.List;

public interface IUserService {

    User registerUser(String firstName, String lastName);
    User getUserById(int id);
    List<User> getUserByFirstName(String firstName);
    List<User> getUserByLastName(String lastName);
    List<User> findByFirstNameContainingIgnoreCase(String firstName);
    List<User> getAll();
    User addUser(User user);
    boolean delete(int id);


}

