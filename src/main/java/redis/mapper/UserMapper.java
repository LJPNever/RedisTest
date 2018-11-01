package redis.mapper;

import redis.Model.User;

import java.util.List;

public interface UserMapper {
    List<User> getAll();
    User selectById(int id);
    int add(User user);
}
