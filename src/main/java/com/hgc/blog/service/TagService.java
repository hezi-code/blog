package com.hgc.blog.service;/**
 * ClassName:TagService
 * Package:com.hgc.blog.service
 * description:
 *
 * @Date:2021/4/1 14:34
 * @aUTHOR:HGC
 */

import com.hgc.blog.po.Tag;
import com.hgc.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *ClassName:TagService
 */
public interface TagService {
    //保存
    Tag saveTag(Tag tag);
    //查询
    Tag  getTag(Long id);
    //通过名称查询
    Tag  getTagByName(String name);
    //分页
    Page<Tag> listTag(Pageable pageable);
    //修改
    Tag  updateTag(Long id ,Tag tag);

    List<Tag> listTag();

    List<Tag> listTag(String ids);
    //删除
    void deleteTag(Long id);

    List<Tag> listTagTop(Integer size);
}
