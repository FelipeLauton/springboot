package br.com.stefanini.relacionamento.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {

	private String numero;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
