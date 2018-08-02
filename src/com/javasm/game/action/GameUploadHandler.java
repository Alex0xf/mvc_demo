package com.javasm.game.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game_upload")
public class GameUploadHandler {

	@RequestMapping(value = "upload_one", method = RequestMethod.POST)
	public ModelAndView upOneFile(MultipartFile gameIcon, HttpServletRequest request)
			throws IllegalStateException, IOException {
		// 进行文件上传 start 每次上传文件都必须知道1.上传到哪 2.传的名字 3.内容是什么
		// 1.上传到哪
		// 获得当前request的上下文的真实地址
		String savePath = request.getServletContext().getRealPath("/upload");
		File saveFile = new File(savePath);
		// 防止异常 （当没有upload文件夹的时候第一次创建肯定失败 所以第一次创建文件时先创建一个文件夹）如果没有文件夹 则先创建一个文件夹
		if (!saveFile.exists()) {
			saveFile.mkdirs();
		}
		// 创建完文件夹之后在该文件夹下创建刚刚上传的文件
		// 2.传的名字 文件地址为刚创的文件夹的完整路径 名称为上传的文件的原始名称（现在只有文件名和地址 文件里没有内容）
		File file = new File(savePath, gameIcon.getOriginalFilename());
		// 3.内容是什么 复制文件内容进去
		gameIcon.transferTo(file);

		// 进行文件上传 end

		// 创建一个ModelAndView对象来传值 对象 和页面跳转
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("savePath", savePath + gameIcon.getOriginalFilename());// 将文件的存储地址+文件名设置
																						// 传递给下一个界面
		modelAndView.addObject("viewPath", "upload/" + gameIcon.getOriginalFilename());// 为了让上传的图片在当前的jsp页面显示而设置
		// 设置转发地址
		modelAndView.setViewName("game/add");
		return modelAndView;
	}

	@RequestMapping("upload_many")
	public ModelAndView upManyFile(@RequestParam("gameIcon") List<MultipartFile> gameIconList, String gamename,
			String gameurl, HttpServletRequest request) throws IllegalStateException, IOException {
		// gameIcon 对应的是input中的name属性 每文件的input name都是 gameIcon
		System.out.println("接收到参数:" + gamename + "#####" + gameurl);
		for (MultipartFile gameIcon : gameIconList) {
			if (gameIcon != null && gameIcon.getSize() > 0 && !gameIcon.getOriginalFilename().isEmpty()) {
				// 与单独文件上传一致
				// 存文件的路径
				String savePath = request.getServletContext().getRealPath("/upload");
				File saveFile = new File(savePath);
				if (!saveFile.exists()) {
					saveFile.mkdirs();
				}
				File file = new File(savePath, gameIcon.getOriginalFilename());
				gameIcon.transferTo(file);// 把file对象 存入指定的文件夹下 复制文件
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("game/add");
		return mv;
	}
}
