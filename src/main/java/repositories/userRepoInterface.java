package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.User;

@Repository
public interface userRepoInterface  extends  JpaRepository<User, String>{

    Optional<User> findByEmail(String email);

    // public Object findByEmail(String email);

    // public Object findByEmail(String email);

   
}
