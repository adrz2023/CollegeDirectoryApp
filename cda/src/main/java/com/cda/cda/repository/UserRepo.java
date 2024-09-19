package com.cda.cda.repository;

import com.cda.cda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo  extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByName(String name);
}
