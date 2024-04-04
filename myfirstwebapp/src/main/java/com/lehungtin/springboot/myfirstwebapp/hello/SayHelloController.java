package com.lehungtin.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
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
}
