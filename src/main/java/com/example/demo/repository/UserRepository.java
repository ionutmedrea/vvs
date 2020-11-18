package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository <User, Long> {
    @Query(value = "SELECT u from User u WHERE u.username = ?1")
    User findByUsername(String username);

    @Query(value = "SELECT u from User u WHERE u.username = ?1")
    boolean existsByUsername(String username);

    @Query(value = "SELECT u from User u WHERE u.password = ?1")
    boolean existsByPassword(String password);
}
