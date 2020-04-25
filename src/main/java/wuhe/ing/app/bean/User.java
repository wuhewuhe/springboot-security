package wuhe.ing.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private int passport;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private int age;
    
	public User(Integer id, int passport, String name, int age) {
		super();
		this.id = id;
		this.passport = passport;
		this.name = name;
		this.age = age;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPassport() {
		return passport;
	}

	public void setPassport(int passport) {
		this.passport = passport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", passport=" + passport + ", name=" + name + ", age=" + age + "]";
	}
    
    

}
