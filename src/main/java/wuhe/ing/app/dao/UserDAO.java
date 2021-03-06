package wuhe.ing.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import wuhe.ing.app.bean.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u where u.name = :name") 
	User findByUsername(@Param("name") String name);

	//User getUserByUsername(String username);

}
