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

### 从零构建轻量级服务器宝塔篇

我们开发中使用的服务器应用和程序均通过服务器来运行，现在云服务器日益火热，不管是作为个人使用还是公司集群搭建都是非常便捷的

##### 购买云服务器【要办事，先花钱】

一般云服务器可以选择阿里云、腾讯云、百度云、华为云，此处以腾讯云举例

![image-20211218164031740](https://wangbin-3014001.oss-cn-shanghai.aliyuncs.com/img/image-20211218164031740.png)

服务器从入门到高性能多核心不等，当然价格也是千差万别。动辄几万元一年的这种服务器就是公司级别的选择了，作为个人千元左右就可以了，新用户和学生有近1-2折的优惠，爽它一年不香吗

![image-20211218165122799](https://wangbin-3014001.oss-cn-shanghai.aliyuncs.com/img/image-20211218165122799.png)

购物之后进入控制台登录启动

![image-20211218165517276](https://wangbin-3014001.oss-cn-shanghai.aliyuncs.com/img/image-20211218165517276.png)

这样一台云服务器它不就有了嘛

#### 宝塔面板

作为初学者，最烦的就是安装配置各种服务和工具，常因为一些字面上的小错误排查好几天，头都扣烂了。现在一款自动化应用安装管理神器它来了，没错是她是他就是它，我的英雄小宝塔

Centos安装命令

```shell
yum install -y wget && wget -O install.sh http://download.bt.cn/install/install_6.0.sh && sh install.sh
```

安装完成就可以看到宝塔面板的URL,账号密码

![image-20211218170504800](https://wangbin-3014001.oss-cn-shanghai.aliyuncs.com/img/image-20211218170504800.png)

当然也可以如下命令来查看bt 配置

```shell
/etc/init.d/bt default
```

![image-20211218170616033](https://wangbin-3014001.oss-cn-shanghai.aliyuncs.com/img/image-20211218170616033.png)



打开面板看看

![image-20211218170904112](https://wangbin-3014001.oss-cn-shanghai.aliyuncs.com/img/image-20211218170904112.png)

看到没，塔不就有了嘛

##### 安装服务

打开软件商店搜索安装即可

![image-20211218171011785](https://wangbin-3014001.oss-cn-shanghai.aliyuncs.com/img/image-20211218171011785.png)

##### 开放端口

宝塔安装的应用端口会自动开启，如果是自己服务器安装的应用需要在这里手动开放端口

![image-20211218171147056](https://wangbin-3014001.oss-cn-shanghai.aliyuncs.com/img/image-20211218171147056.png)

开放端口后，外网就可以访问了


### sentinel 实战
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