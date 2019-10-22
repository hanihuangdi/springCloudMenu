package com.southwind.controller;
import com.southwind.entity.UserVO;
import com.southwind.repository.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserClientHandler {
    @Autowired
    private UserFeign userFeign;
    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page")int page, @RequestParam("limit") int limit){
        return userFeign.findAll(page,limit);
    }
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location")String location){
        return location;
    }
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")long id){
        userFeign.deleteById(id);
        return "redirect:/redirect/user_manage";
    }
}
