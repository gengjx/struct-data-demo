# spring-boot-web-demo

一个最小可运行的 Spring Boot Web 示例，用于练习：
- REST API
- 参数校验（Validation）
- 统一返回体
- 全局异常处理

## 运行

在仓库根目录执行：

```bash
mvn -pl spring-boot-web-demo -DskipTests spring-boot:run
```

## 接口示例

- GET `http://localhost:8080/api/users/1`
- POST `http://localhost:8080/api/users`

请求体：

```json
{
  "name": "tom",
  "email": "tom@example.com"
}
```
