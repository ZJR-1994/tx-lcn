package com.demo.serviceb.base.exception;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tracing.TracingContext;
import com.demo.serviceb.base.ret.Result;
import com.demo.serviceb.base.ret.RetResult;
import com.demo.serviceb.base.ret.RetCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * controller 增强器 处理controller层所有exception拦截
 * 
 */
@ControllerAdvice
public class BaseControllerAdvice {
	public static final Logger logger = LoggerFactory.getLogger(BaseControllerAdvice.class);

	/**
	 * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	}

	/**
	 * 全局异常捕捉处理
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public RetResult<String> errorHandler(Exception ex) {
//		logger.error(ex.fillInStackTrace().toString(), ex);
		ex.printStackTrace();
		return Result.error(ex.fillInStackTrace().toString());
	}

	/**
	 * 全局异常捕捉处理
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = BaseException.class)
	public RetResult<String> errorHandler2(BaseException ex) {
		logger.error(ex.fillInStackTrace().toString(), ex);

		String applicationId = Transactions.getApplicationId();
		System.out.println("#########"+applicationId);

		int errorCode = ex.getCode() == 0 ? RetCode.FAIL.getCode() : ex.getCode();
		String errorMsg = ex.getMsg() == null ? "" : ex.getMsg();

		// todo：根据code获取详细的描述
		switch (errorCode) {
		case 1001: {
			errorMsg = "data not found.";
		}
			break;
		case 1002: {
			// todo:
		}
			break;
		default:
		}

		return Result.makeRsp(errorCode, errorMsg);
	}
}
