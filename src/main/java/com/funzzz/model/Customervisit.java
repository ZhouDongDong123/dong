package com.funzzz.model;

import java.util.Date;


public class Customervisit {
    private Integer id;

    private Integer cid;

    private Integer empId;

    private String contact;
    private Date date;
    
    //增强字段
    private String username;
    private String cusname;
    
    
    private String formatDate;
    
    
    
    
    public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCusname() {
		return cusname;
	}

	public void setCusname(String cusname) {
		this.cusname = cusname;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

  
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}





	@Override
	public String toString() {
		return "Customervisit [id=" + id + ", cid=" + cid + ", empId=" + empId + ", contact=" + contact + ", date="
				+ date + ", username=" + username + ", cusname=" + cusname + ", formatDate=" + formatDate + "]";
	}

	public Customervisit(Integer id, Integer cid, Integer empId, String contact, Date date) {
		super();
		this.id = id;
		this.cid = cid;
		this.empId = empId;
		this.contact = contact;
		this.date = date;
	}

	public Customervisit() {
		super();
	}
    
}