package com.itheima.case2.dao;


import com.itheima.case2.pojo.po.User;
import com.itheima.case2.pojo.vo.QueryPageBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select count(*) from t_user")
    int getTotal();


    @Select("select * from t_user limit #{startIndex},#{pageSize}")
    List<User> findByPage(@Param("startIndex")int startIndex,@Param("pageSize")int pageSize);

}
