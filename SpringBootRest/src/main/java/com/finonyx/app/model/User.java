package com.finonyx.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	@Past(message = "Birth date should be in the past")
	private Date birthDate;
	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	protected User() {

	}

	public User(Long id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
}
