package com.hgc.blog.dao;

import com.hgc.blog.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * ClassName:TypeRepository
 * Package:com.hgc.blog.dao
 * description:
 *
 * @Date:2021/3/30 9:31
 * @aUTHOR:HGC
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);

}
