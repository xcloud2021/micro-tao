# 服务本地运行

本地运行依赖于 docker-compose

## 运行

```bash
docker-compose up -d
```

注意： 微服务启动依赖比较复杂，需等待1~2分钟后服务方可正常访问

## 使用

- 内置用户: [可在这里查到](mysql-init-files/init.sql)
- 访问地址： http://localhost/
- eureka界面地址：　http://localhost:6001/
- 商品折扣配置: [在这里](config/config-server/config/config-product.yml)
- 商品折扣配置配置动态刷新方法：　`docker exec -it service_product_1 bash -c "curl -v -XPOST http://localhost:8080/api/v1/product/actuator/bus-refresh"`
