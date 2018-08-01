package com.javasm.game.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * 
 * ClassName: GameAction 
 * @Description: BeanNameUrlHandelerMapping测试类
 * @author Alex
 * @date 2018年8月1日
 */
public class GameAction extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("hello","hello SpringMVC");
		modelAndView.setViewName("game/hello");
		return modelAndView;
	}

}
