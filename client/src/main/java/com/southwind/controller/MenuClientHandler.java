package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import com.southwind.repository.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuClientHandler {
    @Autowired
    private MenuFeign menuFeign;
    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam(name="page")int page, @RequestParam(name="limit") int limit){

       return menuFeign.findAll(page,limit);
    }
    @GetMapping("/redirect/{location}")
    public String index(@PathVariable(name="location")String location){
        return location;
    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable(name="id")long id){
      Menu menu =  menuFeign.update(id);
      List<Type> list = menuFeign.findType();
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("menu_update");
      modelAndView.addObject("menu",menu);
      modelAndView.addObject("list",list);
      return  modelAndView;
    }
    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/index";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")long id){
        menuFeign.delete(id);
        return "redirect:/menu/redirect/index";
    }
    @GetMapping("/menu_add")
     public ModelAndView menuAdd(){
        List<Type> list = menuFeign.findType();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/menu_add");
        modelAndView.addObject("list",list);
        return modelAndView;
     }
    @PostMapping("/save")
    public String save(Menu menu){
       menuFeign.save(menu);
        return "redirect:/menu/redirect/index";
    }

}
