### 微服务
- 服务注册
  - Spring Cloud Alibaba Nacos Server 2.1.1
  访问路径：http://119.91.150.36:8848/nacos/index.html#
---

任务:
1. 完成视频观看20-27
2. 去服务器启动Nacos服务
3. 了解服务注册/服务调用/配置中心/网关的作用
4. 将各模块进行服务注册到Nacos
5. 在ware服务编写test接口，其他模块（除common/gateway）能使用OpenFeign调用此接口


备注：
- Nacos服务
    - 服务器：119.91.150.36
    - 服务器账号密码：oprator/Oprat!o@r#
    - Nacos存放地址 `/opt/cloud/nacos/`
    - Nacos启动命令 `sh startup.sh -m standalone`