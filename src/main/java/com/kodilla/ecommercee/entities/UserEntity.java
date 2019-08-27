package com.kodilla.ecommercee.entities;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID", nullable = false)
	private int id;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST NAME", nullable = false)
	private String lastName;
	@Column(name = "ADRESS", nullable = false)
	private String adress;
	@Column(name = "PHONE", nullable = false)
	private String phone;

	public UserEntity () {}

	public UserEntity(String firstName, String lastName, String adress, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}
	private void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}
	private void setPhone(String phone) {
		this.phone = phone;
	}
}