package com.leyou.common.dto;

import com.leyou.common.entity.BaseEntity;
import com.leyou.common.utils.BeanHelper;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 基本的DTO，提供了DTO和Entity之间的互相转换功能
 */
@Data
public abstract class BaseDTO {

    /**
     * DTO转PO
     * @param entityClass PO对象的字节码
     * @param <T> PO对象的类型
     * @return PO对象
     */
    public <T> T toEntity(Class<T> entityClass) {
        return BeanHelper.copyProperties(this, entityClass);
    }

    /**
     * 从Entity转为DTO
     * @param entity 任意实体
     */
    public BaseDTO(BaseEntity entity) {
        if(entity != null){
            BeanUtils.copyProperties(entity, this);
        }
    }

    public BaseDTO() {
    }
}
