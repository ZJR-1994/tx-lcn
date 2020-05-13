package com.demo.serviceb.base.ret;

public class Result {
	private final static String SUCCESS = "success";

	public static <T> RetResult<T> success() {
		return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS);
	}

	public static <T> RetResult<T> success(T data) {
		return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data);
	}

	public static <T> RetResult<T> success(String message, T data) {
		return new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(message).setData(data);
	}

	public static <T> RetResult<T> error(String message) {
		return new RetResult<T>().setCode(RetCode.FAIL).setMsg(message);
	}

	public static <T> RetResult<T> error(String message, T data) {
		return new RetResult<T>().setCode(RetCode.FAIL).setMsg(message).setData(data);
	}

	public static <T> RetResult<T> makeRsp(int code, String msg) {
		return new RetResult<T>().setCode(code).setMsg(msg);
	}

	public static <T> RetResult<T> makeRsp(int code, String msg, T data) {
		return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
	}
}
