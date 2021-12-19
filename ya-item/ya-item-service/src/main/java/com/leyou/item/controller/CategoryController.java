package com.leyou.item.controller;

import com.leyou.item.dto.CategoryDTO;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }*/


    /**
     * 根据id查询分类
     */

    @GetMapping("{id}")
    public ResponseEntity<CategoryDTO> queryCategoryById(@PathVariable("id") Long id){
        return ResponseEntity.ok(new CategoryDTO(categoryService.getById(id)));
    }

    /**
     * 根据分类id集合查询分类集合
     * @param ids
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<CategoryDTO>> queryCategoryByIds(@RequestParam("ids") List<Long> ids){
        return ResponseEntity.ok(CategoryDTO.convertEntityList(categoryService.listByIds(ids)));
    }


    @GetMapping("/of/parent")
    public ResponseEntity<List<CategoryDTO>> queryCategoryByParentId(@RequestParam("pid") Long pid){
        return ResponseEntity.ok(// 封装并返回
                CategoryDTO.convertEntityList(// 把PO集合转为DTO集合
                        categoryService.query().eq("parent_id", pid).list()// 根据父类目id查询集合
                )
        );
    }


}
