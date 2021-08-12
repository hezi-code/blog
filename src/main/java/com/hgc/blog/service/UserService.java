package com.hgc.blog.service;

import com.hgc.blog.po.User;

/**
 * ClassName:UserService
 * Package:com.hgc.blog.service
 * description:
 *
 * @Date:2021/3/29 14:58
 * @aUTHOR:HGC
 */
public interface UserService {
    User checkUser(String username,String password);

}
