package com.yasoft.labs.lab6.recorder.utils;

import com.yasoft.labs.lab6.recorder.model.User;
import org.springframework.security.core.Authentication;

public class Util {
    public static User getUser(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }
}
