package br.com.stefanini.projetoredireciona.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVendedor;
	@Column(length = 50)
	private String nome;
	@Column
	private Double comissao;
	private String email;
	private String senha;

	public Vendedor() {
		// TODO Auto-generated constructor stub
	}

	public Vendedor(Long idVendedor, String nome, Double comissao, String email, String senha) {
		super();
		this.idVendedor = idVendedor;
		this.nome = nome;
		this.comissao = comissao;
		this.email = email;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Vendedor [idVendedor=" + idVendedor + ", nome=" + nome + ", comissao=" + comissao + ", email=" + email
				 + "]";
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getComissao() {
		return comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
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
