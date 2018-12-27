package com.base.electric.dao.cache;

import com.base.electric.dao.inter.UserDao;
import com.base.electric.domain.ElecUser;
import org.springframework.stereotype.Component;

@Component
public class UserCache extends CommonCache implements UserDao {

    public void saveUser(ElecUser user) {
        saveOneData(user, user.getLogonname(), user.getLogonpwd());
    }

    @Override
    public ElecUser queryUserByNameAndPwd(String username, String pwd) {
        return getOneData(ElecUser.class, username, pwd);
    }


}
