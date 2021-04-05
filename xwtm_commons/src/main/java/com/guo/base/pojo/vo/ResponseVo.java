package com.guo.base.pojo.vo;

import com.guo.base.pojo.enums.enumResponse;

import java.io.Serializable;

/**
 * 类描述：
 *
 * @ClassName ResponseVo
 * @Description 系统响应信息实体类
 * @Author 郭佳
 * @Date 2021/3/20 20:17
 * @Version 1.0
 */
public class ResponseVo<E> implements Serializable {
	private static final long serialVersionUID = -265475459759501563L;
	private Integer code;
	private E data;

	private ResponseVo(Integer code, E data) {
		this.code = code;
		this.data = data;
	}

	private ResponseVo(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * <b>获得系统相应成功视图信息</b>
	 */
	public static ResponseVo getSuccessResponse(){
		return new ResponseVo(enumResponse.RESP_SUCCESS_CODE.getCode());
	}

	/**
	 * <b>获得系统相应成功视图信息</b>
	 */
	public static ResponseVo getSuccessResponse(Object data){
		return new ResponseVo(enumResponse.RESP_SUCCESS_CODE.getCode(),data);
	}

	/**
	 * <b>获得系统相应错误视图信息</b>
	 */
	public static ResponseVo getErrorResponse(Object data){
		return new ResponseVo(enumResponse.RESP_ERROR_CODE.getCode(),data);
	}

	/**
	 * <b>获得系统相应异常视图信息</b>
	 */
	public static ResponseVo getExceptionResponse(Object data){
		return new ResponseVo(enumResponse.RESP_EXCEPTION_CODE.getCode(),data);
	}

	/**
	 * <b>用户未登录</b>
	 */
	public static ResponseVo getNologinResponse(Object data){
		return new ResponseVo(enumResponse.RESP_NOLOGIN_CODE.getCode(),data);
	}
}