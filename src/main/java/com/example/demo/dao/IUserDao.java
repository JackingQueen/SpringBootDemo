package com.example.demo.dao;

import com.example.demo.domain.User;

import java.util.List;

public interface IUserDao {
    public void save(User user);

    public void update(User user);

    public void delete(Long id);

    public List<User> getAll();

    public User findOne(Long id);
}
