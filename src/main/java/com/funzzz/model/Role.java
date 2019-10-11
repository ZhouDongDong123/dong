package com.funzzz.model;

import java.util.List;

public class Role {
    private Integer roleid;

    private String rolename;

    private String roleinfo;
    private List<String> parent; //角色对应的权限名
    
    public List<String> getParent() {
		return parent;
	}

	public void setParent(List<String> parent) {
		this.parent = parent;
	}

	public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoleinfo() {
        return roleinfo;
    }

    public void setRoleinfo(String roleinfo) {
        this.roleinfo = roleinfo == null ? null : roleinfo.trim();
    }

	public Role(Integer roleid, String rolename, String roleinfo, List<String> parent) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.roleinfo = roleinfo;
		this.parent = parent;
	}

	public Role() {
		super();
	}

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", roleinfo=" + roleinfo + ", parent=" + parent
				+ "]";
	}
    
}