package br.com.stefanini.relacionamento.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=80)
	private String nome;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="telefone", joinColumns = @JoinColumn(name="id_cliente"))
	private List<String> telefones = new ArrayList<String>();
	
	public Cliente() {
		
	}

	public Cliente(Long id, String nome, List<String> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", telefones=" + telefones + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
	

}
