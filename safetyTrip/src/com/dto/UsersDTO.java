package com.dto;

public class UsersDTO {
	private int uno;			//번호
	private String userid;		//아이디
	private String passwd;		//비밀번호
	private String email;		//이메일
	private String uname;		//닉네임
	private String name;		//이름
	private String passport;	//여권번호
	private String sex;			//성별
	private String birth;			//생일
	private String post;			//우편번호
	private String address1;	//주소1
	private String address2;	//주소2
	private String createdate;	//가입날짜
	private int eaccess;		//이메일 승인처리
	
	public UsersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsersDTO(int uno, String userid, String passwd, String email, String uname, String name, String passport,
			String sex, String birth, String post, String address1, String address2, String createdate, int eaccess) {
		super();
		this.uno = uno;
		this.userid = userid;
		this.passwd = passwd;
		this.email = email;
		this.uname = uname;
		this.name = name;
		this.passport = passport;
		this.sex = sex;
		this.birth = birth;
		this.post = post;
		this.address1 = address1;
		this.address2 = address2;
		this.createdate = createdate;
		this.eaccess = eaccess;
	}

	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public int getEaccess() {
		return eaccess;
	}

	public void setEaccess(int eaccess) {
		this.eaccess = eaccess;
	}

	
	
}
