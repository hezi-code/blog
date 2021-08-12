package com.hgc.blog.po;/**
 * ClassName:Tag
 * Package:com.hgc.blog.po
 * description:
 *
 * @Date:2021/3/28 20:19
 * @aUTHOR:HGC
 */

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 *ClassName:Tag
 */
@Entity
@Table(name="t_tag")
public class Tag {
    @Id
    @GeneratedValue
    private  Long id;
    @NotBlank(message = "标签名称不能为空")
    private String name;

    public Tag() {
    }

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
