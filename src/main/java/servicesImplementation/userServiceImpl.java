package servicesImplementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.User;
import helper.ResourceNotFoundException;
import repositories.userRepoInterface;
import services.userServiceInterface;

@Service
public class userServiceImpl implements userServiceInterface{

    @Autowired
    private userRepoInterface userRepoInterface;

    // private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'saveUser'");

        String userId = UUID.randomUUID().toString();
        


        return userRepoInterface.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
        return userRepoInterface.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'updateUser'");

        // jo database se aarahai hai
        User user2 = userRepoInterface.findById(user.getUserId())
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // update karenge user2 from user
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());
        // save the user in database

        User save = userRepoInterface.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
        
        User user2 = userRepoInterface.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepoInterface.delete(user2);

    }

    @Override
    public boolean isUserExist(String userId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'isUserExist'");
        User user2 = userRepoInterface.findById(userId).orElse(null);
        
        return user2 != null ? true: false ;

    }

    @Override
    public boolean isUserExistByEmail(String email) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'isUserExistByEmail'");
        
        User user  = userRepoInterface.findByEmail(email).orElse(null);
        
        return user != null ? true: false ;

    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
        return userRepoInterface.findAll();
    }


}
