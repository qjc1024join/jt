package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.pojo.Item;

import java.util.List;

public interface ItemMapper extends BaseMapper<Item> {


    List<Item> findByList(Page page);
}
