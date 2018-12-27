package com.base.electric.dao.inter;

import com.base.electric.domain.ElecUser;

public interface UserDao {


    public ElecUser queryUserByNameAndPwd(String username, String pwd);

}
