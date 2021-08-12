package com.hgc.blog.service;

import com.hgc.blog.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * ClassName:TypeService
 * Package:com.hgc.blog.service
 * description:
 *
 * @Date:2021/3/30 9:27
 * @aUTHOR:HGC
 */
public interface TypeService {
    //保存
    Type saveType(Type type);
    //查询
    Type getType(Long id);
    //通过名称查询
    Type getTypeByName(String name);
    //分页
    Page<Type> listType(Pageable pageable);
    //修改
    Type updateType(Long id ,Type type);
    //删除
    void deleteType(Long id);
    //返回是所有的数据
    List<Type> listType();

    List<Type> listTypeTop(Integer size);

}
