package br.com.stefanini.projetorelacionamento.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsers;
	@Column(length = 50)
	@JsonProperty(value = "username")
	private String userName;
	@Column(length = 100)
	private String email;
	@JsonManagedReference(value = "address")
	@OneToOne(mappedBy = "users", cascade = { CascadeType.ALL })
	@PrimaryKeyJoinColumn
	private Address address;

	public Users() {

	}

	public Users(Long idUsers, String userName, String email) {
		super();
		this.idUsers = idUsers;
		this.userName = userName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [idUsers=" + idUsers + ", userName=" + userName + ", email=" + email + ", address=" + address + "]";
	}

	public Long getIdUsers() {
		return idUsers;
	}

	public void setIdUser(Long idUsers) {
		this.idUsers = idUsers;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
