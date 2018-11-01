package redis.service;

import redis.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User selectById(int id);
    int add(User user);
}
