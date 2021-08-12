package com.hgc.blog.web.admin;/**
 * ClassName:TypeController
 * Package:com.hgc.blog.web.admin
 * description:
 *
 * @Date:2021/3/30 9:40
 * @aUTHOR:HGC
 */

import com.hgc.blog.po.Type;
import com.hgc.blog.po.User;
import com.hgc.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.jws.WebParam;
import javax.validation.Valid;

/**
 *ClassName:TypeController
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 10, sort = {"id"},direction= Sort.Direction.DESC)
                                    Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";

    }
    @PostMapping("/types")
    public String post(@Valid  Type type, BindingResult result, RedirectAttributes attributes){
        Type t= typeService.getTypeByName(type.getName());
        if(t!=null){
            result.rejectValue("name","nameError","不能添加重复的分类");
        }

        //如果输入有错误，则报错
        if(result.hasErrors()){
            return "admin/types-input";
        }
       Type type1 =  typeService.saveType(type);
       if(type1 == null){
           attributes.addFlashAttribute("message","新增失败");
           //
       }else{
           attributes.addFlashAttribute("message","新增成功");
           //
       }
       return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editpost(@Valid  Type type, BindingResult result,@PathVariable Long id, RedirectAttributes attributes){
        Type t= typeService.getTypeByName(type.getName());
        if(t!=null){
            result.rejectValue("name","nameError","不能添加重复的分类");
        }

        //如果输入有错误，则报错
        if(result.hasErrors()){
            return "admin/types-input";
        }
        Type type1 =  typeService.updateType(id,type);
        if(type1 == null){
            attributes.addFlashAttribute("message","更新失败");
            //
        }else{
            attributes.addFlashAttribute("message","更新成功");
            //
        }
        return "redirect:/admin/types";
    }
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id ,RedirectAttributes attributes){
        typeService.deleteType((id));
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
}
