package com.yasoft.labs.lab6.recorder.controller.api;

import com.yasoft.labs.lab6.recorder.interfaces.services.RecorderService;
import com.yasoft.labs.lab6.recorder.interfaces.services.UserService;
import com.yasoft.labs.lab6.recorder.model.Recorder;
import com.yasoft.labs.lab6.recorder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/users")
public class UserApiController {
    private UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> get() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        User userResult = userService.findById(id);
        if (userResult != null) {
            return new ResponseEntity<>(userResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<User> post(@RequestBody User user) {
        User userResult = userService.create(user);
        if (userResult != null) {
            return new ResponseEntity<>(userResult, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> put(@PathVariable Integer id, @RequestBody User user) {
        User userResult = userService.update(id, user);
        if (userResult != null) {
            return new ResponseEntity<>(userResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id) {
        User userResult = userService.delete(id);
        if (userResult != null) {
            return new ResponseEntity<>(userResult, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
