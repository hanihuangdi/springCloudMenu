package com.southwind.repository;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("order")
public interface OrderFeign {
    @GetMapping("/order/findAllByState/{state}/{page}/{limit}")
    OrderVO findAllByState(@PathVariable("state")int state, @PathVariable("page")int page, @PathVariable("limit")int limit);
    @GetMapping("/order/countByState/{state}")
    int countByState(@PathVariable("state") int state);
    @GetMapping("/order/findAllById/{uid}/{page}/{limit}")
    OrderVO findAllById(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit);
}
