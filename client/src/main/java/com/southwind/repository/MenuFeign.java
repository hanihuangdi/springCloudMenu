package com.southwind.repository;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {
  @GetMapping("/menu/findAll/{page}/{limit}")
  MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);
}
