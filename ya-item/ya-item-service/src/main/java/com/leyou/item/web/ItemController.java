package com.leyou.item.web;

import com.leyou.item.entity.Item;
import com.leyou.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> saveItem(Item item){
        try {
            Item item1 = itemService.saveItem(item);
            // 新增成功, 返回201
            return ResponseEntity.status(HttpStatus.CREATED).body(item1);
        } catch (Exception e) {
            // 失败，返回400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

}
