package com.yasoft.labs.lab6.recorder.interfaces.services;

import com.yasoft.labs.lab6.recorder.model.Record;
import com.yasoft.labs.lab6.recorder.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User findByLogin(String login);
    User create(User user);
    User update(Integer id, User user);
    User delete(Integer id);
}
