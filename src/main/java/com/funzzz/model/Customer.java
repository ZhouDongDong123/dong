package com.funzzz.model;

import java.util.List;

public class Customer {
    private Integer cid;

    private String cusname;

    private String address;

    private String contact;

    private String tel;

    private String email;

    //扩展bean 用来显示所有专员名字拼接
    private String username;
    //一个顾客可能对应多个专员,这个用来存放专员信息
    private List<Employees> list;
    
    public List<Employees> getList() {
		return list;
	}

	public void setList(List<Employees> list) {
		this.list = list;
	}



	public Customer(String cusname, String address, String contact, String tel, String email, String username) {
		super();
		this.cusname = cusname;
		this.address = address;
		this.contact = contact;
		this.tel = tel;
		this.email = email;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname == null ? null : cusname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }



	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cusname=" + cusname + ", address=" + address + ", contact=" + contact
				+ ", tel=" + tel + ", email=" + email + ", username=" + username + ", list=" + list + "]";
	}

	public Customer(Integer cid, String cusname, String address, String contact, String tel, String email) {
		super();
		this.cid = cid;
		this.cusname = cusname;
		this.address = address;
		this.contact = contact;
		this.tel = tel;
		this.email = email;
	}

	public Customer() {
		super();
	}
    
    
}