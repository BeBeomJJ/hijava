package org.edwith.webbe.securityexam.dto;

import java.util.Date;

public class Freeboard {
	
	private int number;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	private int id;
	private String title;
	private String content;
	private String memberEmail;
	private Date createDate;
	private Date modifyDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "Freeboard [id=" + id + ", title=" + title + ", content=" + content + ", memberEmail=" + memberEmail
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}
	
	

}
