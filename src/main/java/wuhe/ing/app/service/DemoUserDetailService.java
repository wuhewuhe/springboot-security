package wuhe.ing.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import wuhe.ing.app.bean.UserRole;
import wuhe.ing.app.dao.RoleDAO;
import wuhe.ing.app.dao.UserDAO;
import wuhe.ing.app.dao.UserRoleDAO;

@Service
public class DemoUserDetailService implements UserDetailsService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	UserRoleDAO userroleDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		wuhe.ing.app.bean.User user = userDAO.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username + " not found");

		List<UserRole> userRoles = userroleDAO.listByUserId(user.getidUser());
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (UserRole ur : userRoles) {
			int roleId = ur.getIdRole();
			String roleName = roleDAO.findById(roleId).get().getRole();
			if (!StringUtils.isEmpty(roleName)) {
				authorities.add(new SimpleGrantedAuthority(roleName));
			}
			System.err.println("username is " + username + ", " + roleName);
		}
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}

}
