package com.hgc.blog.vo;/**
 * ClassName:BlogQuery
 * Package:com.hgc.blog.vo
 * description:
 *
 * @Date:2021/4/1 18:24
 * @aUTHOR:HGC
 */

/**
 *ClassName:BlogQuery
 */
public class BlogQuery {

    private String title;
    private Long typeId;
    boolean recommend;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }
}
