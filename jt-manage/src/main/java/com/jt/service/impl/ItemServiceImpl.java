package com.jt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ItemDescMapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemService;
import com.jt.vo.EasyUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescMapper itemDescMapper;
    @Override
    public EasyUIData<Item> getItemList(Integer page, Integer rows) {
        if(page==1){
            page=page-1;
        }
        //int start=(page-1)*rows;
        Page<Item> itemIPage=new Page<>(page,rows);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.orderByDesc("updated");
        IPage<Item> itemIPage1 = itemMapper.selectPage(itemIPage, queryWrapper);
        List<Item> records = itemIPage1.getRecords();
        EasyUIData responseResult=new EasyUIData();
        responseResult.setRows(records);
        responseResult.setTotal((int) itemIPage.getTotal());
        System.out.println("===============");
        return responseResult;
    }
    @Transactional
    @Override
    public void saveItem(Item item, String desc) {
        item.setStatus(1);
        item.setCreated(new Date());
        item.setUpdated(item.getCreated());
        itemMapper.insert(item);

        ItemDesc itemDesc=new ItemDesc();
        itemDesc.setItemDesc(desc);
        itemDesc.setItemId(item.getId());
        itemDesc.setCreated(item.getCreated());
        itemDesc.setUpdated(item.getUpdated());
        itemDescMapper.insert(itemDesc);
        System.out.println(item.getId());
    }

    @Override
    public ItemDesc findItemById(Long itemId) {
        return itemDescMapper.selectById(itemId);
    }

    @Override
    public void updateItem(Item item, String desc) {
        item.setUpdated(new Date());
        itemMapper.updateById(item);
        ItemDesc itemDesc=new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(item.getUpdated());
        itemDescMapper.updateById(itemDesc);
    }

    @Override
    public void deleteItemById(Long [] id) {
        List<Long> disList=Arrays.asList(id);
        for (Long aLong : disList) {
            itemMapper.deleteById(aLong);
            itemDescMapper.deleteById(aLong);
        }

      /*  */
    }

    @Override
    public void instockById(Long [] ids) {
        Item item=new Item();
        item.setStatus(2).setUpdated(new Date());
        List<Long> idsList= Arrays.asList(ids);
        UpdateWrapper queryWrapper=new UpdateWrapper();
        queryWrapper.in("id",idsList);
        itemMapper.update(item,queryWrapper);
    }

    @Override
    public void reshelfById(Long[] ids) {
        Item item=new Item();
        item.setStatus(1).setUpdated(new Date());
        List<Long> idsList= Arrays.asList(ids);
        UpdateWrapper queryWrapper=new UpdateWrapper();
        queryWrapper.in("id",idsList);
        itemMapper.update(item,queryWrapper);
    }
}
