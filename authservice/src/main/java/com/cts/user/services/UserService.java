package com.cts.user.services;

import com.cts.user.domain.User;
import com.cts.user.exception.UserAlreadyExistsException;
import com.cts.user.exception.UserNotFoundException;

public interface UserService {
    boolean saveUser(User user)
    		throws UserAlreadyExistsException;

   public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;
}
