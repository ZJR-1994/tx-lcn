package com.demo.serviceb.base.ret;

/**
 * @Description: 返回对象实体
 * @author Minhua.He
 *
 * @param <T>
 */
public class RetResult<T> {

	public int code;// 响应码 0:成功,非0:失败

	private String msg;// 响应信息描述

	private T data;// 响应数据


	public RetResult<T> setCode(RetCode retCode) {
		this.code = retCode.getCode();
		return this;
	}

	public int getCode() {
		return code;
	}

	public RetResult<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public RetResult<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public RetResult<T> setData(T data) {
		this.data = data;
		return this;
	}
}
