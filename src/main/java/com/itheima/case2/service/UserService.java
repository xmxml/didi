package com.itheima.case2.service;

import com.itheima.case2.dao.UserMapper;
import com.itheima.case2.pojo.po.User;
import com.itheima.case2.pojo.vo.PageResult;
import com.itheima.case2.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {
    /*
    public PageResult selectByPage(QueryPageBean queryPageBean){
        SqlSession session = SqlSessionUtil.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.findUserByPage(queryPageBean);
        Long total = mapper.findUserTotal();
        PageResult pageResult = new PageResult(total, list);
        session.close();
        return pageResult;
    }

     */

    public PageResult findAllByPage(int i, int i1) {
        SqlSession sqlSession = SqlSessionUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        long total = userMapper.getTotal();
        int startIndex = (i-1)*i1;
        List<User> list = userMapper.findByPage(startIndex,i1);
        SqlSessionUtil.commitAndClose(sqlSession);
        return new PageResult(total,list);
    }
}
