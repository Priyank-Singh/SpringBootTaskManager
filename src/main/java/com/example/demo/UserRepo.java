package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
	
    Optional<User> findOneByEmailAndPassword(String email, String password);
    
    User findByEmail(String email);

}
