package com.hedgehog.user_api.service;

import com.hedgehog.user_api.model.User;
import com.hedgehog.user_api.storage.IUserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;


    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findByFirstNameContainingIgnoreCase(String firstName) {
        return userRepository.findByFirstNameContainingIgnoreCase(firstName);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName);
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        return userRepository.findAllByLastName(lastName);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return false;
        } else {
            userRepository.delete(user);
            return true;
        }
    }


    @Override
    public User registerUser(String firstName, String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        validationForSignUp(user);
        userRepository.save(user);
        return user;
    }

    private void validationForSignUp(User user) {
        String errorMessage = "";
        if (this.nullOrEmpty(user.getFirstName())) {
            errorMessage += "Имя обязательно для заполнения";
        }
        if (this.nullOrEmpty(user.getLastName())) {
            if (!errorMessage.isEmpty()) {
                errorMessage += "; ";
            }
            errorMessage += "Фамилия обязательна для заполнения";
        }

        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
//        if (!userRepository.findAllByLastName(user.getLastName()).isEmpty() && !userRepository.findAllByFirstName(user.getFirstName()).isEmpty()) {
        if (!userRepository.findAllByLastName(user.getLastName()).isEmpty() && !userRepository.findAllByFirstName(user.getFirstName()).isEmpty()) {
            throw new IllegalArgumentException("Этот пользователь уже существует");
        }
    }

    private boolean nullOrEmpty(String val) {
        return val == null || val.isEmpty();
    }

}
