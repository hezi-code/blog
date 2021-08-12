package com.hgc.blog.service;

import com.hgc.blog.po.Blog;
import com.hgc.blog.vo.BlogQuery;
import org.jboss.logging.BasicLogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * ClassName:BlogService
 * Package:com.hgc.blog.service
 * description:
 *
 * @Date:2021/4/1 15:30
 * @aUTHOR:HGC
 */
public interface BlogService {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);


    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Page<Blog> listBlog(String query,Pageable pageable);

    Blog  saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);

    List<Blog> listRecommendBlogTop(Integer size);


    Map<String,List<Blog>> archiveBlog();

    Long countBlog();
}
