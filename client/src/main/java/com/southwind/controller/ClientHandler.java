package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.repository.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class ClientHandler {
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
}
