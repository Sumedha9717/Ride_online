package com.rideCompany.model;

public class User {

	public User(String name, String email, String password, String status) {
		this.name=name;
		this.email=email;
		this.password=password;
		this.status=status;
	}

	public User(String email, String password, String status) {
		this.email=email;
		this.password=password;
		this.status=status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Integer id;
	private  String name;
	private  String  email;
	private  String password;
	private  String status;



}