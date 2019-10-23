package com.southwind.controller;

import com.southwind.entity.Account;
import com.southwind.entity.Admin;
import com.southwind.entity.User;
import com.southwind.repository.AccountFeign;
import com.southwind.utils.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/account")
public class AccountClientHandler {
    @Autowired
    AccountFeign accountFeign;
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Account account = accountFeign.login(username,password,type);
        String target = null;
        if(account == null){
            target = "login";
        }else{
            switch (type){
                case "user":
                    User user = convertUser(account);
                    session.setAttribute("user",user);
                    target = "redirect:/account/redirect/index";
                    break;
                case "admin":
                    Admin admin = convertAdmin(account);
                    session.setAttribute("admin",admin);
                    target = "redirect:/account/redirect/main";
                    break;
            }
        }
        return target;
    }

    private User convertUser(Account account){
        User user = new User();
        user.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
        user.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
        user.setGender(ReflectUtils.getFieldValue(account,"gender")+"");
        user.setId((long)(ReflectUtils.getFieldValue(account,"id")));
        user.setNickname(ReflectUtils.getFieldValue(account,"nickname")+"");
        user.setRegisterdate((Date)(ReflectUtils.getFieldValue(account,"registerdate")));
        user.setTelephone(ReflectUtils.getFieldValue(account,"telephone")+"");
        return user;
    }

    private Admin convertAdmin(Account account){
        Admin admin = new Admin();
        admin.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
        admin.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
        admin.setId((long)(ReflectUtils.getFieldValue(account,"id")));
        return admin;
    }
}
