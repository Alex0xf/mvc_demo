package com.javasm.user.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * ClassName: LoginHandler 
 * @Description: 登录的方法
 * @author Alex
 * @date 2018年8月6日
 */
@Controller
@RequestMapping("/login")
public class LoginHandler {
	
	@RequestMapping("loginPage")
	 public String jumpLoginPage(){
		 
		 return "login/login";
	 }
	
	@RequestMapping("doLogin")
	public String doLogin(String username,String password,HttpServletRequest request){
		if("root".equals(username)){
			request.getSession().setAttribute("user_name",username);
		}
		return "login/index";
	}
}
