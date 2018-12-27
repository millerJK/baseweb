package com.base.electric.dao.db;

import com.base.electric.dao.inter.UserDao;
import com.base.electric.domain.ElecUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDaoDb extends UserDao {

    @Override
    @Select("select * from elec_user where userName = #{username} and logonPwd = #{pwd}")
    ElecUser queryUserByNameAndPwd(@Param("username") String username, @Param("pwd") String pwd);
}
