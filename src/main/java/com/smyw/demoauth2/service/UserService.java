package com.smyw.demoauth2.service;

import com.smyw.demoauth2.domian.UserRepository;
import com.smyw.demoauth2.domian.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luojuan
 * @create 2017-11-20 16:30
 **/
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id){
        return userRepository.findOne(id);
    }

    public User findUserByName(String name){
        return userRepository.findByName(name);
    }
}
