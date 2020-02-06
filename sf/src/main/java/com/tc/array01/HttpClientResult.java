package com.tc.array01;

import java.io.Serializable;

/**
 * Description: 封装httpClient响应结果
 * 
 * @author JourWon
 * @date Created on 2018年4月19日
 */
public class HttpClientResult implements Serializable {

	/**
	 * 响应状态码
	 */
	private int code;

	/**
	 * 响应数据
	 */
	private String content;

	public HttpClientResult(int code, String content) {
		this.code = code;
		this.content = content;
	}

	public HttpClientResult(int code) {
		this.code = code;
	}
}
