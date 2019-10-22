package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import com.southwind.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
       List<User> list =  userRepository.findAll((page-1)*limit,limit);
       UserVO userVO = new UserVO();
       userVO.setData(list);
       userVO.setCode(0);
       userVO.setCount(userRepository.count());
       userVO.setMsg("");
        return userVO;
    }
    @GetMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") long id){
        userRepository.deleteById(id);

    }

}
