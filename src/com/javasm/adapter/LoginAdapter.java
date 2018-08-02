package com.javasm.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * ClassName: LoginAdapter 
 * @Description: 登录拦截器
 * @author Alex
 * @date 2018年8月3日
 */
public class LoginAdapter extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		System.out.println("登录拦截器被调用");
		//校验session里的数据 有没有  
		//先去session中获取对应的字段/数据  如果能拿到说明已经登录  如果拿不到 说明未登录  未登录 跳转到登录页面
		//如果是登录页面 或者登录方法 不拦截
		String url = request.getRequestURI();
		if(url.endsWith("loginPage")|| url.endsWith("doLogin")){
			return super.preHandle(request, response, handler);
		}
		HttpSession session = request.getSession();
		//session中获取数据
		String username = (String) session.getAttribute("user_name");
		if(username == null || username.trim().isEmpty()){
			//登录失败
			request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
			//重定向到登录页
			//response.sendRedirect(request.getContextPath()+"/login/loginPage");
		}
		return super.preHandle(request, response, handler);
	}
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("afterConcurrentHandlingStarted");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		super.postHandle(request, response, handler, modelAndView);
	}
}
