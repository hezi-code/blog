package com.hgc.blog.web;/**
 * ClassName:IndexController
 * Package:com.hgc.blog.web
 * description:
 *
 * @Date:2021/3/24 10:52
 * @aUTHOR:HGC
 */

import com.hgc.blog.service.BlogService;
import com.hgc.blog.service.TagService;
import com.hgc.blog.service.TypeService;
import com.hgc.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *ClassName:IndexController
 */
/*@Controller
public class IndexController {
    @GetMapping("/{id}/{name}")
    public String index(@PathVariable Integer id,@PathVariable String name){
       // int i = 9/0;
      //  String blog = null;
       // if(blog==null){
       //     throw new NotFountException("无法找到博客");
       // }

        System.out.println("------------index------------");
        return "index";
    }
}*/

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size = 8, sort = {"updatedTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         Model model){

        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogService.listRecommendBlogTop(8));
        System.out.println("------------index------------");
        return "index";
    }
    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updatedTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query , Model model){
        model.addAttribute("page",blogService.listBlog("%"+query+"%",pageable));
        model.addAttribute("query",query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model){
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "blog";
    }
    @GetMapping("/blog")
    public String blog(){
        // int i = 9/0;
        //  String blog = null;
        // if(blog==null){
        //     throw new NotFountException("无法找到博客");
        // }
        System.out.println("------------blog------------");
        return "blog";
    }
    @GetMapping("/tags")
    public String tags(){
        System.out.println("------------tags------------");
        return "tags";
    }
    @GetMapping("/types")
    public String types(){
        System.out.println("------------types------------");
        return "types";
    }
    @GetMapping("/archive")
    public String archive(){
        System.out.println("------------archive------------");
        return "archive";
    }
    /*@GetMapping("/about")
    public String about(){
        System.out.println("------------about------------");
        return "about";
    }*/
    @GetMapping("/footer/newblog")
    public String newblogs(Model model){
        model.addAttribute("newblogs",blogService.listRecommendBlogTop(3));
        return "_fragments::newblogList";
    }
}
