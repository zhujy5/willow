package com.nanshan.willow.auth.entity;

import java.util.Date;

/**
 * 
 * @ClassName:  User   
 * @Description: 用户
 * @author: zhujy001
 * @date:   2018年2月10日 下午3:33:33
 *
 */
public class User {
	
	private int userId; 
	private String userRelevanceId;
	private String userAccount;
	private String nickName;
	private String password;
	private Date lastLogin;
	private String passwordStatus;
	private String userStatus;
	private Integer passwordTryNum;
	private String iphone;
	private String registerType;
	private String wxOpenId;
	private String macAddress;
	private String mobileBrand;
	private String mobileSystem;
	private String headPic;
	private String roleCode;
	private String wxNickName;
	
	public String getWxNickName() {
		return wxNickName;
	}
	public void setWxNickName(String wxNickName) {
		this.wxNickName = wxNickName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public String getWxOpenId() {
		return wxOpenId;
	}
	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}
	public String getIphone() {
		return iphone;
	}
	public void setIphone(String iphone) {
		this.iphone = iphone;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPasswordStatus() {
		return passwordStatus;
	}

	public void setPasswordStatus(String passwordStatus) {
		this.passwordStatus = passwordStatus;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public Integer getPasswordTryNum() {
		return passwordTryNum;
	}
	public void setPasswordTryNum(Integer passwordTryNum) {
		this.passwordTryNum = passwordTryNum;
	}
	public String getRegisterType() {
		return registerType;
	}
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getMobileBrand() {
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}
	public String getMobileSystem() {
		return mobileSystem;
	}
	public void setMobileSystem(String mobileSystem) {
		this.mobileSystem = mobileSystem;
	}
	public String getUserRelevanceId() {
		return userRelevanceId;
	}
	public void setUserRelevanceId(String userRelevanceId) {
		this.userRelevanceId = userRelevanceId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userRelevanceId=" + userRelevanceId + ", userAccount=" + userAccount
				+ ", nickName=" + nickName + ", password=" + password + ", lastLogin=" + lastLogin + ", passwordStatus="
				+ passwordStatus + ", userStatus=" + userStatus + ", passwordTryNum=" + passwordTryNum + ", iphone="
				+ iphone + ", registerType=" + registerType + ", wxOpenId=" + wxOpenId + ", macAddress=" + macAddress
				+ ", mobileBrand=" + mobileBrand + ", mobileSystem=" + mobileSystem + ", headPic=" + headPic
				+ ", roleCode=" + roleCode + ", wxNickName=" + wxNickName + "]";
	}
	
	
}
