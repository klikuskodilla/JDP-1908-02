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
	private int userKey;
	@Column(name = "LOGIN")
	private String login;
	@Column(name = "PASSWORD")
	private String password;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "CREDENTIAL_ID")
	private CredentialEntity credentialEntity;
}