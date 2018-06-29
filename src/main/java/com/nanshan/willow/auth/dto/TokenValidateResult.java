package com.nanshan.willow.auth.dto;

public class TokenValidateResult {
	/**
	 * 更新token
	 */
	private String refreshToken;

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

}
