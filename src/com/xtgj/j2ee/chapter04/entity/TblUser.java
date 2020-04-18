package com.xtgj.j2ee.chapter04.entity;

import java.util.HashSet;
import java.util.Set;

public class TblUser implements java.io.Serializable {
	private Integer uid;
	private String uname;
	private String upass;
	private Set tblFwxxes = new HashSet(0);

	public TblUser() {
	}

	public TblUser(String uname, String upass) {
		this.uname = uname;
		this.upass = upass;
	}

	public TblUser(String uname, String upass, Set tblFwxxes) {
		this.uname = uname;
		this.upass = upass;
		this.tblFwxxes = tblFwxxes;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public Set getTblFwxxes() {
		return tblFwxxes;
	}

	public void setTblFwxxes(Set tblFwxxes) {
		this.tblFwxxes = tblFwxxes;
	}

}
