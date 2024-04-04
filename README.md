# learn-spring-boot

## Monitor (Actuator)
- Mở file **pom.xml** và thêm đoạn **dependency** sau vào **dependencies**

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

- Sau khi thêm dependency **actuator** vào thì khi chạy ứng dụng, gõ thêm đường dẫn đuôi **/actuator** để vào giao diện chi tiết

Ví dụ:
```
http://localhost:8080/actuator/
```

- Để cấu hình thêm chi tiết actuator thì mở file **application.properties** thêm dòng lệnh sau vào

```
management.endpoints.web.exposure.include=[type]
```

- Với **[type]** bao gồm:
  + *: Tất cả actuator
  + beans: Tất cả danh sách Spring beans trong ứng dụng
  + health: Thông tin Health của ứng dụng
  + metrics: Metrics của ứng dụng
  + mappings: Chi tiết các Request Mappings
- Sau khi thêm vào loại, để vào chi tiết, thêm path sau vào, ví dụ:
```
http://localhost:8080/actuator/metrics

http://localhost:8080/actuator/metrics/http.server.requests
```

## Devtool (Auto reload)
- Mở file **pom.xml** và thêm đoạn **dependency** sau vào **dependencies**

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

## Debug
- Xem chi tiết các loại log hệ thống, làm theo thao tác sau
- Mở file **application.properties** và thêm vào đoạn sau

```
logging.level.org.springframework=[type]
```

- Với **[type]** theo thứ tự chi tiết dần từ trái qua như sau: **trace, debug, info, warning, error, off**.

## Profiles
- Để tạo nhiều profile dành riêng cho từng môi trường với nhu cầu khác nhau, ví dụ: prod, uat, dev, QC... làm theo các thao tác sau
- Mở file **application.properties** và thêm vào đoạn sau

```
logging.level.org.springframework=[type]
```

- Với **[type]** theo thứ tự chi tiết dần từ trái qua như sau: **trace, debug, info, warning, error, off**.