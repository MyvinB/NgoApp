package com.cts.user.services;

import java.util.Map;

import com.cts.user.domain.User;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
