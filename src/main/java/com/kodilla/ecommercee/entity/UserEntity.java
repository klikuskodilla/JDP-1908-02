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
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;
	@Column(name = "STATUS")
	private int status;
	@Column(name = "USER_KEY")
	private String userKey;
	@Column(name = "LOGIN")
	private String login;
	@Column(name = "PASSWORD")
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
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "MAIL", nullable = false)
	private String mail;
}