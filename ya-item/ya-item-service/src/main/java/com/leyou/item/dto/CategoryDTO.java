package com.leyou.item.dto;

import com.leyou.common.dto.BaseDTO;
import com.leyou.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoryDTO extends BaseDTO {
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;

    public CategoryDTO(BaseEntity entity){
        super(entity);
    }


    /**
     * 将PO转换为DTO集合
     */

    public static <T extends BaseEntity> List<CategoryDTO> convertEntityList(Collection<T> list){

        if (list == null){
            return Collections.emptyList();
        }

        return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }


}
