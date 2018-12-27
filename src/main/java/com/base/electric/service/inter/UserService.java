package com.base.electric.service.inter;

import com.base.electric.domain.ElecUser;

public interface UserService {

    public ElecUser findUserByNameAndPwd(String username, String pwd);
}
