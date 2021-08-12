package com.hgc.blog.dao;/**
 * ClassName:UserRepository
 * Package:com.hgc.blog.dao
 * description:
 *
 * @Date:2021/3/29 15:01
 * @aUTHOR:HGC
 */

import com.hgc.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *ClassName:UserRepository
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);

}
