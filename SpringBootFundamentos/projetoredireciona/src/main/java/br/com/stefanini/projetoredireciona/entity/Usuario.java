package br.com.stefanini.projetoredireciona.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuario")
public class Usuario {
	//@SequenceGenerator(name="sequenciaum", initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String name;
	@JsonProperty(value = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private java.util.Date dataNascimento;
	private String email;
	private String senha;

	public Usuario() {

	}

	public Usuario(Long id, String name, Date dataNascimento, String email, String senha) {
		super();
		this.id = id;
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", dataNascimento=" + dataNascimento + ", email=" + email
				 + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(java.util.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
