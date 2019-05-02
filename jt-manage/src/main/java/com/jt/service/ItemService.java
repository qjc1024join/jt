package com.jt.service;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.vo.EasyUIData;

public interface ItemService {

    EasyUIData<Item> getItemList(Integer page, Integer rows);

    void saveItem(Item item, String desc);


    ItemDesc findItemById(Long itemId);

    void updateItem(Item item, String desc);

    void deleteItemById(Long [] id);

    void instockById(Long [] ids);

    void reshelfById(Long[] ids);
}
