package br.com.stefanini.twodatabases.model;

public class UsersEvent {

	private Object id;
	private String code;
	private String event;
	private String status;
	
	private String users;
	
	public UsersEvent() {
	}

	public UsersEvent(Object id, String code, String event, String status) {
		super();
		this.id = id;
		this.code = code;
		this.event = event;
		this.status = status;
	}

	public UsersEvent(String code, String event, String status, String users) {
		super();
		this.code = code;
		this.event = event;
		this.status = status;
		this.users = users;
	}

	public UsersEvent(Object id, String code, String event, String status, String users) {
		super();
		this.id = id;
		this.code = code;
		this.event = event;
		this.status = status;
		this.users = users;
	}

	@Override
	public String toString() {
		return "UsersEvent [id=" + id + ", code=" + code + ", event=" + event + ", status=" + status + "]";
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}
}
