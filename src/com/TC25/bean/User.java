package com.TC25.bean;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7339627732512884272L;
	
	private int userId;
	private String userAcc;
	private String userName;
	private String userPwd;
	private String userPwdTip;
	private int userStatus;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAcc() {
		return userAcc;
	}
	public void setUserAcc(String userAcc) {
		this.userAcc = userAcc;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPwdTip() {
		return userPwdTip;
	}
	public void setUserPwdTip(String userPwdTip) {
		this.userPwdTip = userPwdTip;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	public User(String userAcc, String userName, String userPwd, String userPwdTip) {
		//--用户ID 等待实际放入时不读取这个ID
		this(0, userAcc, userName, userPwd, userPwdTip, 1);
	}
	public User(int userId, String userAcc, String userName, String userPwd, String userPwdTip, int userStatus) {
		super();
		this.userId = userId;
		this.userAcc = userAcc;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userPwdTip = userPwdTip;
		this.userStatus = userStatus;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAcc + ", userName=" + userName + ", userPwd="
				+ userPwd + ", userPwdTips=" + userPwdTip + ", userStatus=" + userStatus + "]";
	}
	
	

}
