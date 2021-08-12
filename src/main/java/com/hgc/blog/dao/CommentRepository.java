package com.hgc.blog.dao;

import com.hgc.blog.po.Blog;
import com.hgc.blog.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:CommentRepository
 * Package:com.hgc.blog.dao
 * description:
 *
 * @Date:2021/4/8 15:49
 * @aUTHOR:HGC
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);

    @Transactional
    @Modifying
    void deleteByBlog(Blog blog);
}
