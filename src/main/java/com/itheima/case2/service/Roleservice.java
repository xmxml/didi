package com.itheima.case2.service;

import com.itheima.case2.dao.RoleMapper;
import com.itheima.case2.pojo.po.Role;
import com.itheima.case2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Roleservice {
    public List<Role> findAll() {
        SqlSession session = SqlSessionUtil.getSession();
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        List<Role> all = mapper.findAll();
        SqlSessionUtil.commitAndClose(session);
        return all;
    }
}
