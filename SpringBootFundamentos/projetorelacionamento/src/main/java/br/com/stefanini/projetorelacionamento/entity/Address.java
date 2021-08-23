package br.com.stefanini.projetorelacionamento.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "address", uniqueConstraints = {@UniqueConstraint(columnNames = {"city"}) })
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAddress;
	private String city;
	private String state;
	@JsonBackReference(value = "address")
	@OneToOne
	@JoinColumn(name = "id_users", referencedColumnName = "idUsers")
	private Users users;

	public Address() {

	}

	public Address(Long idAddress, String city, String state) {
		super();
		this.idAddress = idAddress;
		this.city = city;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [idAddress=" + idAddress + ", city=" + city + ", state=" + state + ", users=" + users + "]";
	}

	public Long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Users getUsers() {
		return users;
	}

	public void setUser(Users users) {
		this.users = users;
	}

}
