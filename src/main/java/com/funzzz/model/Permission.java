package com.funzzz.model;

import java.util.List;

public class Permission {
    private Integer permissionid;

    private String pname;

    private String purl;

    private Integer ismenu;

    private Integer parentid;

    private String pinfo;
    
    private String pcolor;
    
    
    public Permission(Integer permissionid, String pname, String purl, Integer ismenu, Integer parentid, String pinfo,
			String pcolor, List<Permission> list) {
		super();
		this.permissionid = permissionid;
		this.pname = pname;
		this.purl = purl;
		this.ismenu = ismenu;
		this.parentid = parentid;
		this.pinfo = pinfo;
		this.pcolor = pcolor;
		this.list = list;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	private List<Permission> list;//改权限的子权限集合
    
    public List<Permission> getList() {
		return list;
	}

	public void setList(List<Permission> list) {
		this.list = list;
	}

	public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl == null ? null : purl.trim();
    }

    public Integer getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo == null ? null : pinfo.trim();
    }

	public Permission(Integer permissionid, String pname, String purl, Integer ismenu, Integer parentid, String pinfo,
			List<Permission> list) {
		super();
		this.permissionid = permissionid;
		this.pname = pname;
		this.purl = purl;
		this.ismenu = ismenu;
		this.parentid = parentid;
		this.pinfo = pinfo;
		this.list = list;
	}

	public Permission() {
		super();
	}

	@Override
	public String toString() {
		return "Permission [permissionid=" + permissionid + ", pname=" + pname + ", purl=" + purl + ", ismenu=" + ismenu
				+ ", parentid=" + parentid + ", pinfo=" + pinfo + ", pcolor=" + pcolor + ", list=" + list + "]";
	}
    
}