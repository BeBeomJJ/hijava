package org.edwith.webbe.securityexam.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AddComment {

	private int id;
	private String memberEmail;
	private int freeboardNo;
	private String comment;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getFreeboardNo() {
		return freeboardNo;
	}
	public void setFreeboardNo(int freeboardNo) {
		this.freeboardNo = freeboardNo;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "AddComment [id=" + id + ", memberEmail=" + memberEmail + ", freeboardNo=" + freeboardNo + ", comment="
				+ comment + ", createDate=" + createDate + "]";
	}
	
	
}
