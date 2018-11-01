package redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.Model.User;
import redis.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/get")
    @Cacheable(value="users", key="1")
    public List<User> get(){
        Map map=new HashMap();

        return userService.getAll();
    }

    @ResponseBody
    @RequestMapping("/getId")
    public User get(int id){

        return userService.selectById(id);
    }

    @ResponseBody
    @RequestMapping("/add")
    @CacheEvict(value="users", key="1")
    public Map add(@RequestBody User user){
        Map map=new HashMap();
        map.put("data",userService.add(user));
        return map;
    }

}
