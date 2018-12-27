package com.base.electric.dao.impl;

import com.base.electric.dao.cache.UserCache;
import com.base.electric.dao.db.UserDaoDb;
import com.base.electric.dao.inter.UserDao;
import com.base.electric.domain.ElecUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserCache userCache;
    @Autowired
    private UserDaoDb userDaoDb;

    private Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public ElecUser queryUserByNameAndPwd(String username, String pwd) {

        ElecUser user = userCache.queryUserByNameAndPwd(username, pwd);
        if (user == null) {
            ElecUser elecUser = userDaoDb.queryUserByNameAndPwd(username, pwd);
            if (user != null) {
                userCache.saveUser(user);
                logger.info("登录成功");
                return elecUser;
            }
        }else {
            logger.info("缓存查询失败");
        }
        return user;
    }
}
