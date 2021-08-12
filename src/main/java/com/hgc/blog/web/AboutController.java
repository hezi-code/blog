package com.hgc.blog.web;/**
 * ClassName:AboutCOntroller
 * Package:com.hgc.blog.web
 * description:
 *
 * @Date:2021/4/9 18:24
 * @aUTHOR:HGC
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *ClassName:AboutCOntroller
 */
@Controller
public class AboutController {

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
