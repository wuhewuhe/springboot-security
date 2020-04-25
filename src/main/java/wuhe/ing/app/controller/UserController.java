package wuhe.ing.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wuhe.ing.app.bean.JSONResult;
import wuhe.ing.app.bean.User;
import wuhe.ing.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/listAll")
	public List<User> listAll() {
		return userService.listAll();
	}

	@GetMapping("/detail")
	public JSONResult findById(int id) {
		Optional<User> opt = userService.findById(id);
		return new JSONResult(opt.get());
	}

	@PostMapping("/create")
	public JSONResult create(@RequestParam(value = "age") int age, @RequestParam(value = "passport") int passport,
			@RequestParam(value = "name") String name) {
		User user = userService.add(age, name, passport);
		return new JSONResult(userService.save(user));
	}
}
