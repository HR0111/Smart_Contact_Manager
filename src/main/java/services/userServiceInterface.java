package services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Entity.User;

@Service
public interface userServiceInterface {

    User saveUser(User user);
    Optional<User> getUserById(String id);
    Optional<User> updateUser(User user);
    void deleteUser(String id);
    boolean isUserExist(String userId);
    boolean isUserExistByEmail(String email);
    List<User> getAllUsers(); 

    

}
