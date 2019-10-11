package com.funzzz.model;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class Employees {
    private Integer empId;
    @NotEmpty(message = "用户名不能为空")
    private String username;

    private String password;

    private String tel;

    private String name;

    private String email;

    private String emptype;
    
    private int roleId;
    
    //1个员工可以有多个顾客
    private List<Customer> list;
    
    
    public Employees(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}


	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmptype() {
        return emptype;
    }

    public void setEmptype(String emptype) {
        this.emptype = emptype == null ? null : emptype.trim();
    }



	public Employees(Integer empId, String username, String password, String tel, String name, String email,
			String emptype, Integer roleId) {
		super();
		this.empId = empId;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.name = name;
		this.email = email;
		this.emptype = emptype;
		this.roleId = roleId;
	}

	public Employees(String username, String password, String tel, String name, String email, String emptype,
			int roleId) {
		super();
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.name = name;
		this.email = email;
		this.emptype = emptype;
		this.roleId = roleId;
	}

	

	



	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", username=" + username + ", password=" + password + ", tel=" + tel
				+ ", name=" + name + ", email=" + email + ", emptype=" + emptype + ", roleId=" + roleId + ", list="
				+ list + "]";
	}

	public Employees() {
		super();
	}
    
}