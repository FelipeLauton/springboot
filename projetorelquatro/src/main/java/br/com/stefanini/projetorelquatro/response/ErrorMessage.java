package br.com.stefanini.projetorelquatro.response;

public class ErrorMessage {

	private String status;
	private String valor;

	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String status, String valor) {
		super();
		this.status = status;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ErrorMessage [status=" + status + ", valor=" + valor + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
