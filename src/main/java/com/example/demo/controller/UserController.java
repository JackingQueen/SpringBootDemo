package com.example.demo.controller;

import com.example.demo.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> listUser= Collections.synchronizedList(new ArrayList<>());

    /***
     * 获取全部用户信息
     * @return
     */
    @GetMapping("/")
    public List<User> getUserList(){
        return listUser;
    }

    /***
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/")
    public String createUser(User user) {
        listUser.add(user);
        return "success";
    }

    /***
     * 获取指定id用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id")Long id) {
        for (User user : listUser) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    /**
     * 更新指定id用户信息
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    @ApiOperation(value="更新指定id用户信息", notes="根据id更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    public String updateUser(@PathVariable("id") Long id,User user) {
        for (User user2 : listUser) {
            if(user2.getId().equals(id)) {
                user2.setName(user.getName());
                user2.setAge(user.getAge());
            }
        }
        return "success";
    }

    /***
     * 删除指定id用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value="删除指定id用户信息", notes="根据id删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    public String deleteUser(@PathVariable("id") Long id) {

        listUser.remove(getUser(id));
        return "success";

    }

}
