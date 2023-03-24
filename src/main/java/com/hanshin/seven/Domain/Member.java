package com.hanshin.seven.Domain;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString

public class Member {
	private String name;
	private String email;
	private String pwd;
	private String dept;
	private String pos;
	private int empNum;
	
	
	
	public Member() {
		super();
	}

	public Member(String name, String email, String pwd, String dept, String pos, int empNum) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.dept = dept;
		this.pos = pos;
		this.empNum = empNum;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + ", pwd=" + pwd + ", dept=" + dept + ", pos=" + pos
				+ ", empNum=" + empNum + "]";
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	
	
}
