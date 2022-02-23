package com.hedgehog.user_api.storage;

import com.hedgehog.user_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface IUserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByFirstName(String firstName);
    List<User> findAllByLastName(String lastName);
    List<User> findByFirstNameContainingIgnoreCase(String firstName);
    User findById(int id);


}
