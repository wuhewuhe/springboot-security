package wuhe.ing.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wuhe.ing.app.bean.User;
import wuhe.ing.app.dao.UserDAO;

@Service
public class UserService {
	@Autowired
	private UserDAO repo;

	public List<User> listAll() {
		return repo.findAll();
	}

	public Optional<User> findById(int id) {
		return repo.findById(id);
	}

	public User save(User user) {
		return repo.save(user);
	}

	public User add(String name, String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		return user;
	}

}
