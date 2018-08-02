package com.javasm.game.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javasm.game.model.BookModel;
import com.javasm.game.model.GameModel;
import com.javasm.game.vo.PlayVO;

//@Controller 把当前类 注入到Spring容器
//@RequestMapping 配置当前类访问路径
@Controller
@RequestMapping("/game")
public class GameHandler {
	
	@RequestMapping("jsonlist")
	@ResponseBody
	public Map<String,Object> getListJSON(){
		Map<String,Object> map=new HashMap<>();
		map.put("code", 1002);
		GameModel gamemodel = new GameModel();
		gamemodel.setId(12);
		gamemodel.setName("爐石");
		gamemodel.setUrl("www.blz.ccc");
		map.put("game", gamemodel);
		return map;
	}

	@RequestMapping("message") 
	@ResponseBody
	public String fideMessage(){
		return "收到消息";
	}
	
	@RequestMapping("glist")
	@ResponseBody
	public List<GameModel> findeGameList(){
		System.out.println("glist被调用");
		List<GameModel> list = new ArrayList<GameModel>();
		list.add(new GameModel(12,"魔兽","a"));
		list.add(new GameModel(13,"星际","吧"));
		list.add(new GameModel(14,"红警","v"));
		return list;
	}
	
	@RequestMapping("add")
	public String jumpAddPage(){
		return "game/add";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ModelAndView gameTestPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("hello", "注解 Hello SpringMVC");
		modelAndView.setViewName("game/hello");
		return modelAndView;
	}

	@RequestMapping("/test2")
	public String gameTestPage2(Map<String, Object> map) {
		// model.addAttribute("hello", "Hello SpringMVC");
		map.put("hello", "Hello SpringMVC");
		int i=1/0;
		System.out.println(i);
		return "game/hello";// 相当于servlet转发的地址 前后已经在xml文件中配置过
	}

	// 测试参数
	@RequestMapping("/pt")
	public String gameParamTest(Integer id, String name, String url, Model model) {
		GameModel gm = new GameModel(id, name, url);
		String str = "接收到前端的参数id" + id;
		System.out.println(str);
		model.addAttribute("hello", gm.toString());
		return "game/hello";
	}

	// 直接传一个对象 前提条件 必须属性和参数名一一对应
	@RequestMapping("/ptg")
	public String gameParamModelTest(GameModel game, Model model) {
		model.addAttribute("hello", game.toString());
		return "game/hello";
	}

	// 传两个对象
	@RequestMapping("/ptg2")
	public String gameParam2ModelTest(PlayVO vo, Model model) {
		model.addAttribute("hello", vo.getGame().toString() + vo.getBook().toString());
		return "game/hello";
	}

	@RequestMapping("/ptg3")
	public String gameParam2ModelTest(@ModelAttribute("book") BookModel bookmodel,
			@ModelAttribute("game") GameModel gamemodel, Model model) {
		model.addAttribute("hello", bookmodel.toString() + "---" + gamemodel.toString());
		return "game/hello";
	}

	@InitBinder("game")
	public void initGameBinder(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("game.");
	}

	@InitBinder("book")
	public void initBookBinder(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("book.");
	}

	// REST风格的url
	@RequestMapping("/add/{gameid}/{game_name}/page/12")
	public String addBookPage(@PathVariable("gameid") Integer id, @PathVariable("game_name") String name,
			Map<String, Object> map) {
		map.put("hello", id + name);
		return "game/hello";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView myException(Exception e){
		ModelAndView mv = new ModelAndView();
		mv.addObject("myErroMessage", "发生异常/错误####### "+e.getMessage());
		//mv.setViewName("forward:/my_erro.jsp");
		mv.setViewName("500");
		return mv;
	}
}
