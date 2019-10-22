package com.southwind.repository;
import com.southwind.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user")
public interface UserFeign {
    @GetMapping("/user/findAll/{page}/{limit}")
    UserVO findAll(@PathVariable("page")int page, @PathVariable("limit")int limit);
    @GetMapping("/user/deleteById/{id}")
    void deleteById(@PathVariable("id")long id);
}
