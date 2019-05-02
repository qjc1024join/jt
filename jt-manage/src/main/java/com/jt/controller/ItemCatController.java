package com.jt.controller;

import com.jt.service.ItemCatService;
import com.jt.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    ///item/cat/queryItemCatNameById
    @RequestMapping("/queryItemCatNameById")
    public String findItemCatNameById(Long itemCatId){

        return itemCatService.findItemCatNameById(itemCatId);
    }

    @RequestMapping("/list")
    public List<EasyUITree> findItemCatByParentId(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        return itemCatService.findItemCatByParentId(parentId);
    }
}
