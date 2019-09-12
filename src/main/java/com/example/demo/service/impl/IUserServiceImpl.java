package com.example.demo.service.impl;

import com.example.demo.dao.IUserDao;
import com.example.demo.domain.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;

    @Override
    public List<User> getUserList() {
        return iUserDao.getAll();
    }

    @Override
    public void createUser(User user) {
        iUserDao.save(user);
    }

    @Override
    public User getUser(Long id) {
        return iUserDao.findOne(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        user.setId(id);
        iUserDao.update(user);
    }

    @Override
    public void deleteUser(Long id) {
        iUserDao.delete(id);
    }
}
