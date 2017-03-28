package org.arpit.smarthackthon.MedicalRecordTrackingSystem.model;

public class SignIn {

	private int id;
	private int userId;
	private String username;
	private String password;
	private String entityType;
	
	public SignIn(){
		
	}

	public SignIn(int id, int userId, String username, String password, String entityType) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.entityType = entityType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	
}
