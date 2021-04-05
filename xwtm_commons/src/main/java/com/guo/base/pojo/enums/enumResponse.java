package com.guo.base.pojo.enums;

public enum enumResponse {
	RESP_SUCCESS_CODE(enumConstant.RESP_SUCCESS_CODE,"响应成功"),
	RESP_ERROR_CODE(enumConstant.RESP_ERROR_CODE,"响应失败"),
	RESP_EXCEPTION_CODE(enumConstant.RESP_EXCEPTION_CODE,"响应异常"),
	RESP_NOLOGIN_CODE(enumConstant.RESP_NOLOGIN_CODE,"用户为登录");
	private Integer code;
	private String remark;

	 private enumResponse(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
