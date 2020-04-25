package wuhe.ing.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@PreAuthorize("hasRole('ROLE_VIEWER') or hasRole('ROLE_EDITOR')")
	@GetMapping({ "/", "home" })
	public String hello() {
		return "hello";
	}
}
