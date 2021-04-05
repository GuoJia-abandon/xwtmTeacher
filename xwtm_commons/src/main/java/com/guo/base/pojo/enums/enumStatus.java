package com.guo.base.pojo.enums;

public enum enumStatus {
	STATUS_ENABLE(enumConstant.STATUS_ENABLE,"启用"),
	STATUS_DISENABLE(enumConstant.STATUS_DISENABLE,"禁用");
	private Integer code;
	private String remark;

	private enumStatus(Integer code, String remark) {
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
