package com.xxxx.server.exception;

import com.xxxx.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 *
 * @author zhoubin
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalException {



	@ExceptionHandler(value = Exception.class)
	public RespBean exceptionHandler(Exception e) {

		if (e instanceof MyException) {
			MyException pe = (MyException) e;
			return RespBean.error(pe.getMsg());

		}
		if (e instanceof NullPointerException){
			return RespBean.error("空指针异常！");

		}
		if (e instanceof IOException){
			return RespBean.error("IOException");
		}
		if (e instanceof SQLIntegrityConstraintViolationException){
			return RespBean.error("该数据有关联数据，操作失败！");
		}

		return RespBean.error("未知异常");
	}

}