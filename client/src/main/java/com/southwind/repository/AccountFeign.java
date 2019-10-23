package com.southwind.repository;

import com.southwind.entity.Account;
import com.southwind.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account")
public interface AccountFeign {
    @GetMapping("/account/login/{username}/{password}/{type}")
  Account login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type);
}
