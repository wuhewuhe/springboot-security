package wuhe.ing.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wuhe.ing.app.bean.JSONResult;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@GetMapping("/test")
	public String test() {
		int a = 1/0;
		return "error";
	}
	
	@GetMapping("/ajax")
	public String ajax() {
		return "ajaxError";
	}
	
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public JSONResult getAjaxerror() {
		
		int a = 1 / 0;
		
		return JSONResult.ok();
	}
}
