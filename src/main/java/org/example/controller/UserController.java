package org.example.controller;

import org.example.domain.User;
import org.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

//    查询所有
    @RequestMapping ("/getAllUsers")
    public List<User> getAllUsers(){
        List<User> users = userMapper.selectList(null);
        return users;
    }


//    根据id去查询
    @RequestMapping("/getUserByIdWithPath/{uid}")
    public User getUserByIdWithPath(@PathVariable("uid") Integer uid){
        User user = userMapper.selectById(uid);
        return user;
    }





    @RequestMapping("/getUserById")
    public User getUserById(Integer uid){
        User user = userMapper.selectById(uid);
        return user;
    }


//    增加
    @RequestMapping("/insertUser")
    public User insertUser(User user){
        userMapper.insert(user);
        System.out.println("新增成功，新增的数据为："+user);
        return user;
    }

//修改
    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        userMapper.updateById(user);
        System.out.println(user);
        return "修改成功！";
    }


//    根据id删除
    @RequestMapping("/deleteUserById/{uid}")
    public void deleteUserById(@PathVariable("uid") Integer uid) {
        userMapper.deleteById(uid);
        System.out.println("删除成功！");
    }


//    删除
        @RequestMapping("/deleteUserById")
        public void deleteUserById1( Integer uid){
            userMapper.deleteById(uid);
            System.out.println("删除成功！");

    }


}



