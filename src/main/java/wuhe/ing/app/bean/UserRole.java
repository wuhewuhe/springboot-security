package wuhe.ing.app.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRole {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int idUser;
	
	private int idRole;
	
	public UserRole() {
		super();
	}

	public UserRole(int id, int idUser, int idRole) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idRole = idRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", idUser=" + idUser + ", idRole=" + idRole + "]";
	}
	
}
