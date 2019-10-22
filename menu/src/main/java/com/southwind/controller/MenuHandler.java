package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import com.southwind.repository.MenuRepository;
import com.southwind.repository.TypeRepository;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Value("${server.port}")
    private String port;
    @GetMapping("/index")
    public String index(){
        return port;
    }
    @GetMapping("/findAll/{page}/{limit}")
    public MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
        MenuVO menuVO = new MenuVO();
        menuVO.setCode(0);
        menuVO.setMsg("");
        menuVO.setCount(menuRepository.count());
        menuVO.setData(menuRepository.findAll((page-1)*limit,limit));
        return menuVO;
    }
    @GetMapping("/update/{id}")
    public Menu update(@PathVariable(name="id")Long id){
        Menu menu = menuRepository.findById(id);
        if(menu==null){
            return null;
        }
        return menu;
    }
    @PostMapping("/update")
    public void update(@RequestBody Menu menu){
       Menu oldMenu =  menuRepository.findById(menu.getId());
       if (oldMenu==null){
           return;
       }
       menuRepository.update(menu);
    }
    @GetMapping("/findType")
    public List<Type> findType(){
       return typeRepository.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")long id){
        menuRepository.deleteById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuRepository.save(menu);
    }


}
