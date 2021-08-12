package com.hgc.blog.dao;/**
 * ClassName:TagRepository
 * Package:com.hgc.blog.dao
 * description:
 *
 * @Date:2021/4/1 14:42
 * @aUTHOR:HGC
 */

import com.hgc.blog.po.Tag;

import com.hgc.blog.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *ClassName:TagRepository
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);

    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}
