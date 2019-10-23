package com.southwind.controller;

import com.netflix.discovery.converters.Auto;
import com.southwind.entity.Order;
import com.southwind.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    OrderRepository orderRepository;
    @GetMapping("/findAllByStatus/{status}/{page}/{limit}")
    public List<Order> findAllByStatus(@PathVariable("status")int status, @PathVariable("page")int page, @PathVariable("limit")int limit){
        return  orderRepository.findAllByStatus(status,page,limit);
    }
}
