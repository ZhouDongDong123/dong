package com.funzzz.model;

public class Customershare {
    private Integer id;

    private Integer cid;

    private Integer empId;

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

	@Override
	public String toString() {
		return "Customershare [id=" + id + ", cid=" + cid + ", empId=" + empId + "]";
	}

	public Customershare(Integer id, Integer cid, Integer empId) {
		super();
		this.id = id;
		this.cid = cid;
		this.empId = empId;
	}
	
	public Customershare(Integer cid, Integer empId) {
		super();
		this.cid = cid;
		this.empId = empId;
	}

	public Customershare() {
		super();
	}
    
}