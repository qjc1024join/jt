package com.jt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

        @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public String findItemCatNameById(Long itemCatId) {
        ItemCat itemCat = itemCatMapper.selectById(itemCatId);
        String name = itemCat.getName();
        return name;
    }

    @Override
    public List<EasyUITree> findItemCatByParentId(Long parentId) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("parent_id",parentId);
        List<ItemCat> list=itemCatMapper.selectList(queryWrapper);
        List<EasyUITree> easyUITreeList=new ArrayList<>();
        for (ItemCat itemCat : list) {
            Long id=itemCat.getId();
            String text=itemCat.getName();
            String state=itemCat.getIsParent() ? "closed":"open";
            EasyUITree tree=new EasyUITree(id,text,state);
            easyUITreeList.add(tree);
        }
        return easyUITreeList;
    }
}
