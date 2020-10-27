package com.appsdeveloperblog.app.ws.ui.controller;

import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.share.dto.UserDto;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "get";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails){
       UserRest returnValue = new UserRest();

       UserDto userDto = new UserDto();
       BeanUtils.copyProperties(userDetails, userDto);

       UserDto createUser = userService.createUser(userDto);
       BeanUtils.copyProperties(createUser, returnValue);

       return returnValue;
    }

    @PutMapping
    public String updateUser(){
        return "update";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete";
    }
}
