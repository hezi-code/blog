package com.hgc.blog.service;/**
 * ClassName:UserServiceImpl
 * Package:com.hgc.blog.service
 * description:
 *
 * @Date:2021/3/29 15:00
 * @aUTHOR:HGC
 */

import com.hgc.blog.dao.UserRepository;
import com.hgc.blog.po.User;
import com.hgc.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *ClassName:UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user =  userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
