package com.laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class HttpUtil {
	
	private String value;
	
	public HttpUtil(String value) {
		this.setValue(value);
	}
	
	// map field của dữ liệu post qua aip với field trong database tương ứng của model
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	// parse dữ liệu từ reader từ json sang string
	public static HttpUtil of (BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			// bộ linebuffer của BufferReader chứa được 2^12 kí tự (12 ô bit dành cho linebuffer), debug để biết rõ
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		}
		catch (IOException e) {
			e.getMessage();
		}
		return new HttpUtil(sb.toString());
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
