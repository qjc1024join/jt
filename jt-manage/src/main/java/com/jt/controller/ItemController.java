package com.jt.controller;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemService;
import com.jt.vo.EasyUIData;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/query")
    public EasyUIData queryList(Integer page, Integer rows){
        return itemService.getItemList(page,rows);
    }

    @RequestMapping("/save")
    public SysResult saveItem(Item item,String desc){
        try {
            itemService.saveItem(item,desc);
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.fail();
        }
        return SysResult.ok();
    }
    @RequestMapping("/query/item/desc/{itemId}")
    public SysResult findItemDescById(@PathVariable Long itemId){
        ItemDesc itemDesc=null;
        try {
            itemDesc=itemService.findItemById(itemId);
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.fail();
        }
        return SysResult.ok(itemDesc);
    }
    @RequestMapping("/update")
    public SysResult updateItem(Item item,String desc){

        try {
           itemService.updateItem(item,desc);
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.fail();
        }
        return SysResult.ok();
    }

    @RequestMapping("/delete")
    public SysResult deleteById(Long [] ids){
        try {
           itemService.deleteItemById(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.fail();
        }
        return SysResult.ok();
    }

    @RequestMapping("/instock")
    public SysResult instockById(Long [] ids){
        try {
            itemService.instockById(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.ok();
    }


    @RequestMapping("/reshelf")
    public SysResult reshelf(Long [] ids){
        try {
            itemService.reshelfById(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SysResult.ok();
    }
}
