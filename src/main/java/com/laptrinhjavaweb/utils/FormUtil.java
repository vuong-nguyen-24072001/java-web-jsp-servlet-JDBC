package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {

	// map dữ liệu post nhận về(dữ liệu nhận về có dạng key value) với các field trong model
	// khác với toModel của HttpUtil là bên HttpUtil là map đầy đủ các field của 1 model(dùng trong post api), còn ở đây chỉ là 1 vài field nào muốn trong 1 model
	public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
		T object = null;
		try {
			object = clazz.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return object;
	}
	
}
