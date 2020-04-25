package wuhe.ing.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wuhe.ing.app.bean.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer>{

}
