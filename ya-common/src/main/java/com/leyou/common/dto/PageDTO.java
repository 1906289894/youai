package com.leyou.common.dto;

import lombok.Data;

import java.util.List;

/**
 * 通用的分页结果对象
 * @param <T> 分页数据的类型
 */
@Data
public class PageDTO<T> {
    private Long total;// 总条数
    private Long totalPage;// 总页数
    private List<T> items;// 当前页数据

    public PageDTO() {
    }

    public PageDTO(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageDTO(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }
}