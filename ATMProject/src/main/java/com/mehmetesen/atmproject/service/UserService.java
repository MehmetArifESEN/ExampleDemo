
package com.mehmetesen.atmproject.service;

import com.mehmetesen.atmproject.entity.User;
import com.mehmetesen.atmproject.repository.UserRepository;
import com.mehmetesen.atmproject.utility.UserValidation;

/**
 *
 * @author mehme
 */
public class UserService {
    UserRepository repository;
    public UserService() {
        repository = new UserRepository();
        
    }
    public User login(User user) {
        if(UserValidation.checkEmail(user.getEmail())) {
            User loginUser = repository.login(user.getEmail(), user.getPassword());
            return loginUser;
        } else {
            return null;
        }
        
        
    }
}
