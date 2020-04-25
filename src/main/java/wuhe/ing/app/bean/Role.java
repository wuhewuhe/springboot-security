package wuhe.ing.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRole;

	private String role;

	public Integer getIdRole() {
		return idRole;
	}

	public Role() {
		super();
	}

	public Role(Integer idRole, String role) {
		super();
		this.idRole = idRole;
		this.role = role;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", role=" + role + "]";
	}

}
