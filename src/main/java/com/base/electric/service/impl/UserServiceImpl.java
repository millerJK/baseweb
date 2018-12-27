package com.base.electric.service.impl;

import com.base.electric.dao.inter.UserDao;
import com.base.electric.domain.ElecUser;
import com.base.electric.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.US_ASCII;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ElecUser findUserByNameAndPwd(String username, String pwd) {
        return userDao.queryUserByNameAndPwd(username, pwd);
    }
}
