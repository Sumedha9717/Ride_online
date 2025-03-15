package com.rideCompany.model;

public class Book {
	
	private int id;
    private  String name;
    private  String address;
    private  String email;
    private  int mobile;
    private  String nic;
    private  String time;
    private  String date;
    private  String startlocation;
    private  String endlocation;
    private String vehicle;

	public Book(Integer id, String name, String email, String address, String mobile, String nic, String date, String time, String vehicle, String startlocation, String endlocation, String status) {
	this.id=id;
	this.name=name;
	this.email=email;
	this.address=address;
	this.mobile= Integer.parseInt(mobile);
	this.nic=nic;
	this.date=date;
	this.time=time;
	this.vehicle=vehicle;
	this.startlocation=startlocation;
	this.endlocation=endlocation;
	this.status=status;
	}

	public Book(Integer bid, String vehicle, String end, String start, String time, String date, String status) {
		this.id=bid;
		this.date=date;
		this.time=time;
		this.vehicle=vehicle;
		this.startlocation=start;
		this.endlocation=end;
		this.status=status;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String  status;
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartlocation() {
		return startlocation;
	}

	public void setStartlocation(String startlocation) {
		this.startlocation = startlocation;
	}

	public String getEndlocation() {
		return endlocation;
	}

	public void setEndlocation(String endlocation) {
		this.endlocation = endlocation;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}



    public  Book(Integer uid, String address)
    {
        this.id=uid;
        this.address=address;
    }




}
