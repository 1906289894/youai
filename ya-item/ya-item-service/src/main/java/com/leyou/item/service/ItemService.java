package com.leyou.item.service;

import com.leyou.item.entity.Item;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ItemService {
    public Item saveItem(Item item){
        //判断价格是否为空
        if (item.getPrice()==null){
            throw new RuntimeException("价格不能为空！");
        }
        if(item.getName() == null){
            throw new RuntimeException("名称不能为空！");
        }
        // 随机生成id，模拟数据库的新增
        int id = new Random().nextInt(100);
        item.setId(id);
        // 返回新增之后的对象，回显id
        return item;
    }
}
