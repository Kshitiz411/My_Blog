package com.project.entities;

import java.sql.Timestamp;

public class Post {
	
	private int pid;
	private String pTittle;
	private String pContent;
	private String pCode;
	private String pPic;
	private Timestamp pDate;
	private int catId;
	private int userId;
	
	public Post() {
		
	}

	public Post(int pid, String pTittle, String pContent, String pCode, String pPic, Timestamp pDate, int catId , int userId) {
		super();
		this.pid = pid;
		this.pTittle = pTittle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pPic = pPic;
		this.pDate = pDate;
		this.catId = catId;
		this.userId=userId;
	}

	public Post(String pTittle, String pContent, String pCode, String pPic, Timestamp pDate, int catId, int userId) {
		super();
		this.pTittle = pTittle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pPic = pPic;
		this.pDate = pDate;
		this.catId = catId;
		this.userId=userId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getpTittle() {
		return pTittle;
	}

	public void setpTittle(String pTittle) {
		this.pTittle = pTittle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpPic() {
		return pPic;
	}

	public void setpPic(String pPic) {
		this.pPic = pPic;
	}

	public Timestamp getpDate() {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
