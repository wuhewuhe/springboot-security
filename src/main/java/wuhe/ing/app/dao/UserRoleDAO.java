package wuhe.ing.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import wuhe.ing.app.bean.UserRole;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {

	@Query("SELECT u FROM UserRole u where u.idUser = :idUser") 
	List<UserRole> listByUserId(@Param("idUser") Integer idUser);

}
