package com.base.electric.dao.db;

import com.base.electric.dao.inter.UserDao;
import com.base.electric.domain.ElecUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserDaoDb extends UserDao {

    @Override
    @Select("select * from elec_user where logonName = #{logonName} and logonPwd = #{logonPwd}")
    ElecUser queryUserByNameAndPwd(@Param("logonName") String logonName, @Param("logonPwd") String pwd);
}
