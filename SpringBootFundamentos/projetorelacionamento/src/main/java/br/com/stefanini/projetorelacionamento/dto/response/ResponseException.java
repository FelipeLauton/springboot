package br.com.stefanini.projetorelacionamento.dto.response;

public class ResponseException {

	private String status;
	private String value;

	public ResponseException() {
		
	}

	public ResponseException(String status, String value) {
		super();
		this.status = status;
		this.value = value;
	}

	@Override
	public String toString() {
		return "ResponseUserException [status=" + status + ", value=" + value + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
