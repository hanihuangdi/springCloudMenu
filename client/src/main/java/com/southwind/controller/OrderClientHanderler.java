package com.southwind.controller;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import com.southwind.entity.User;
import com.southwind.repository.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderClientHanderler {
    @Autowired
    OrderFeign orderFeign;
    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVO findAllByState(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return orderFeign.findAllByState(0, page, limit);
    }
    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session){
        User user = (User) session.getAttribute("user");
        return orderFeign.findAllById(1, page, limit);
    }
}
