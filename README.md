# learn-spring-boot

## Monitor (Actuator)
- Mở file **pom.xml** và thêm đoạn **dependency** sau vào **dependencies**

```JAVA
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

```Java
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

```Java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

## Debug
- Xem chi tiết các loại log hệ thống, làm theo thao tác sau
- Mở file **application.properties** và thêm vào đoạn sau

```Java
logging.level.org.springframework=[type]
```

- Với **[type]** theo thứ tự chi tiết dần từ trái qua như sau: **trace, debug, info, warning, error, off**.

## Profiles
- Để tạo nhiều profile dành riêng cho từng môi trường với nhu cầu khác nhau, ví dụ: prod, uat, dev, QC... làm theo các thao tác sau
- Mở file **application.properties** và thêm vào đoạn sau

```Java
logging.level.org.springframework=[type]
```

- Với **[type]** theo thứ tự chi tiết dần từ trái qua như sau: **trace, debug, info, warning, error, off**.
#
# Web MVC

## Config application.properties
- Để cấu hình lại port cho web app spring boot khi chạy (Mặc định 8080) thì làm theo các thao tác sau
- Mở file **application.properties** và thêm vào đoạn sau

```Java
server.port=[port]
```

- Để cấu hình Prefix và Suffix thì sử dụng dòng sau
- Sau khi cấu hình 2 dòng này vào, Spring sẽ tự convert và thêm vào return View JSP của Controller

```Java
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

## Java Server Page (JSP)
- Mặc định thư viện Spring sẽ đọc file **View.jsp** ở đường dẫn "/src/main/resources/META-INF/resources/WEB-INF/jsp/[Tên file].jsp"
- Nên để có thể sử dụng View trong Controller phải tạo các thư mục và file ở đường dẫn trên

### Flow Web
1. Client request
2. Spring kiểm tra controller handle URL
3. Spring thêm dữ liệu vào model
4. Spring thực thi lệnh trong handle đó
5. Spring kiểm tra nếu trả về là View JSP thì sử dụng View Resolver để lấy đường dẫn đến JSP
6. Spring trả về (response) nội dung và trạng thái (status) cho client

### Controller
- File Controller đặt tên theo cú pháp PascalCase ví dụ: **LoginController.java**
- File Controller là class
Ví dụ nội dung trong file:

```Java
// @RequestMapping là khai báo của URL
// @ResponseBody để chỉ định trả về client nội dung là String
@RequestMapping("say-hello")
@ResponseBody
public String sayHello() {
  return "Hello World!";
}

// StringBuffer để convert từ HTML sang String
@RequestMapping("say-hello-HTML")
@ResponseBody
public String sayHelloHTML() {
  StringBuffer sb = new StringBuffer();
  sb.append("<html>");
  sb.append("<head>");
  sb.append("<title>");
  sb.append("Hello World HTML");
  sb.append("</title>");
  sb.append("</head>");
  sb.append("<body>");
  sb.append("Hello World HTML");
  sb.append("</body>");
  sb.append("</html>");
  return sb.toString();
}

// Không chỉ định annotation @ResponseBody thì sẽ trả về là View JSP
// Đường dẫn đầy đủ sẽ là "/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp"
// Nhưng vì đã cấu hình PREFIX và SUFFIX ở file "application.properties"
// 	nên Spring sẽ tự convert và bổ sung các FIX đó vào return
@RequestMapping("say-hello-JSP")
public String sayHelloJSP() {
  return "sayHello";
}
```

- Annotation @RequestParam để nhận param và truyền tiếp vào Views
```Java
// Trong @RequestParam:
// + Value: Tên Param
// + required: Chỉ định bắt buộc truyền param (Mặc định là true)
// + defaultValue: Chỉ định giá trị mặc định khi không truyền param (Khi gắn giá trị cho thuộc tính này thì required sẽ là false)

// Để truyền giá trị từ Controller vào View thì phải truyền vào Model, trường hợp này sẽ là ModelMap
@RequestMapping("login")
public String goLogin(@RequestParam(value = "name", required = false, defaultValue = "Guest") String name, ModelMap model) {
  model.put("name", name);
  return "login";
}
```

- Để chỉ định hàm xử lý cho loại phương thức (Method) khác nhau của URL đó thì thêm thuộc tính **method** vào @RequestMapping
```Java
@RequestMapping(value="login", method = RequestMethod.POST)
public String goWelcome(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, ModelMap model) {
  if(authenticationService.authenticate(username, password) ) {
    model.put("username", username);
    return "welcome";			
  }
  model.put("errorMessage", "Invalid credentials, please try again!");
  return "login";
}
```

- Để sử dụng giá trị của Model cho tất cả Controller và Views khác sử dụng thì sử dụng **Session** để lưu
- Đặt annotation vào đầu Class
```Java
@Controller
@SessionAttributes("username") // Lưu username của Model vào Session
public class LoginController {
  ...
}
```
### Views
- Để nhận giá trị truyền vào từ **Controller** thì sử dụng cú pháp
```
${tên_đã_put_vào_model_ở_controller}
```
- Ở ví dụ trên sẽ là
```HTML
<html>
<head>
  <title>Login Page</title>
</head>
<body>
	<div>Welcome to login page ${name}!</div>
</body>
</html>
```
- Để render dữ liệu từng dòng và chỉ định cụ thể dữ liệu cần hiển thị thì sử dụng thư viện **jstl**
- Nhúng dòng lệnh này vào đầu file JSP

```HTML
<!-- Chú ý thuộc tính prefix -->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
```

- Cách sử dụng
```HTML
<!-- prefix khai báo ở trên được sử dụng ở thẻ đóng/mở này -->
<!-- todos là model, var="todo" là biến lưu trữ -->
<c:forEach items="${todos}" var="todo">
  <tr>
    <td>${todo.id}</td>
    <td>${todo.name}</td>
    <td>${todo.description}</td>
    <td>${todo.targetDate}</td>
    <td>${todo.done}</td>
  </tr>
</c:forEach>
```