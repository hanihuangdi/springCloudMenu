package com.southwind.repository;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {
  @GetMapping("/menu/findAll/{page}/{limit}")
  MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);
  @GetMapping("/menu/update/{id}")
  Menu update(@PathVariable("id") long id);
  @GetMapping("/menu/findType")
  List<Type> findType();
  @PostMapping("/menu/update")
  void update(@RequestBody Menu menu);
  @DeleteMapping("/menu/delete/{id}")
  void delete(@PathVariable("id")long id);
  @PostMapping("/menu/save")
  void save(@RequestBody Menu menu);
}
