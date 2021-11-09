# MALL-YOUAI

*优爱商城，潮流儿的购物新潮*



## 项目介绍

`mall-youai`是一套微服务商城系统，采用了 Spring Cloud Alibaba、Spring boot 2.3、Mybatis、Elasticsearch等核心技术，前端基于Vue搭建，项目目前在研发构建中，用到的技术栈也会逐步补充。

## 组织机构

```lua
mall
├── ya-common -- 工具类及通用代码模块
├── ya-gateway -- 基于Spring Cloud Gateway的微服务API网关服务
└── ya-item --核心模块
```

## 项目文档

待补充

## 技术选型

```html
<p>xxx<p>
```

## 技术要点

`sentinel 客户端启动`
```shell
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
```

`git`
```shell
1. 配置git用户名邮箱
2. 生成ssh密钥串
3. 配置ssh_puh到github
4. https切换ssh需要修改git项目路径.git下边的config配置
* 若出现域名问题需要配置 hosts DNS解析,若还是不行 请切换ip多次尝试 
经过尝试可以使用的配置：[52.192.72.89 github.com]
```