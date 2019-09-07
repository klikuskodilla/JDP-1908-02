package com.kodilla.ecommercee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", nullable = false)
	private int id;
	@Column(name = "USER_KEY", nullable = false)
	private String userKey;
	@Column(name = "USER_STATUS", nullable = false)
	private String userStatus;
	@Column(name = "LOGIN", nullable = false)
	private String login;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	@Column(name = "STREET", nullable = false)
	private String street;
	@Column(name = "CITY", nullable = false)
	private String city;
	@Column(name = "POST_CODE", nullable = false)
	private String postCode;
	@Column(name = "PHONE", nullable = false)
	private String phone;
	@Column(name = "MAIL", nullable = false)
	private String mail;

	//konstruktor do testowania:

	public UserEntity(String userKey, String userStatus, String login, String password, String firstName, String lastName, String street, String city, String postCode, String phone, String mail) {
		this.userKey = userKey;
		this.userStatus = userStatus;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.postCode = postCode;
		this.phone = phone;
		this.mail = mail;
	}
}