package com.leyou.common.entity;

import lombok.EqualsAndHashCode;

import java.util.Date;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseEntity {
    private Date createTime;
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
