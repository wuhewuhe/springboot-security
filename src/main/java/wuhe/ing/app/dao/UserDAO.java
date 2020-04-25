package wuhe.ing.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import wuhe.ing.app.bean.User;

@Repository
public interface UserDAO extends JpaRepository<User,Integer>{

}
