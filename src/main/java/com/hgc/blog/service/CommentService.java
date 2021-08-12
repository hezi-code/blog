package com.hgc.blog.service;

import com.hgc.blog.po.Blog;
import com.hgc.blog.po.Comment;

import java.util.List;

/**
 * ClassName:CommentService
 * Package:com.hgc.blog.service
 * description:
 *
 * @Date:2021/4/8 15:46
 * @aUTHOR:HGC
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

    void deleteByBlog(Blog blog);
}
