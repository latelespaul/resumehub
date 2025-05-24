package com.makemework.org.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.makemework.org.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}
