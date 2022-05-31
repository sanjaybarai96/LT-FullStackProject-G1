package com.lt.crs.bean;

import java.util.Date;
import java.util.UUID;

/**
 * @author user217
 *
 */
public class User {

	private UUID userId;
	private String userName;
	private String password;
	private Date createDate;
	private String role;
	private int isApprove;
	private boolean session;
	
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getIsApprove() {
		return isApprove;
	}
	public void setIsApprove(int isApprove) {
		this.isApprove = isApprove;
	}
	public boolean getSession() {
		return session;
	}
	public void setSession(boolean session) {
		this.session = session;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", createDate=" + createDate + ", isApprove="
				+ isApprove + "]";
	}
}
