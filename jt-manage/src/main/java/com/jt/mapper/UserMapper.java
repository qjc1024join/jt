package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;

import java.util.List;
public interface UserMapper extends BaseMapper<User> {
    /*@Param()
    @Select("select * from tb_item limit #{start},#{rows}")*/
    List<User> findAll();
}
