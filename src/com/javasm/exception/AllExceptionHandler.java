package com.javasm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
//注入spring中
@Component
public class AllExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception e) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("allErroMessage", "全局异常#######"+e.getMessage());
		modelAndView.setViewName("500");
		e.printStackTrace();
		return modelAndView;
	}

}
