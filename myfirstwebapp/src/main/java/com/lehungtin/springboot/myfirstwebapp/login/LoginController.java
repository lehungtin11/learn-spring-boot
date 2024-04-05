package com.lehungtin.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method = RequestMethod.GET)
	public String goLogin() {
	    return "login";
	}
	
	@RequestMapping(value="welcome", method = RequestMethod.GET)
	public String goWelcome() {
	    return "welcome";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String goWelcome(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, ModelMap model) {
		if(authenticationService.authenticate(username, password) ) {
			model.put("username", username);
			return "welcome";			
		}
		model.put("errorMessage", "Invalid credentials, please try again!");
		return "login";
	}
}
