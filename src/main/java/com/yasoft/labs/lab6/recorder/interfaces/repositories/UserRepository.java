package com.yasoft.labs.lab6.recorder.interfaces.repositories;

import com.yasoft.labs.lab6.recorder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByLogin(String login);
}
