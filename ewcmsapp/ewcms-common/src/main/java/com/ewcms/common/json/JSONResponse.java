/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.common.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 通过{@link JSONResponse}封装需要返回的数据对象，可以使返回格式一致。
 * 
 * @author <a href="hhywangwei@gmail.com">wangwei</a>
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE)
public class JSONResponse {
	
	/**
	 * 返回操作是否成功 
	 */
	private boolean success = true;
	
	/**
	 * 返回操作输出对象（如：返回值对象等）
	 */
	private Object returnObject ;
	
	/**
	 * 操作异常返回，用于客户调试
	 */
	private Throwable throwable;
	
	/**
	 * 实例操作成功输出对象，{@code success=true}
	 * 
	 * @return
	 */
	public static JSONResponse success(){
		return new JSONResponse(Boolean.TRUE,null,null);
	}
	
	/**
	 * 实例操作成功输出对象，{@code success=true}
	 * 
	 * @param returnObject 返回消息对象
	 * @return
	 */
	public static JSONResponse success(Object returnObject){
		return new JSONResponse(Boolean.TRUE,returnObject,null);
	}
	
	/**
	 * 实例操作失败输出对象，{@code success=false}
	 * 
	 * @return
	 */
	public static JSONResponse fail(){
		return new JSONResponse(Boolean.FALSE,null,null);
	}
	
	/**
	 * 实例操作失败输出对象，{@code success=false}
	 * 
	 * @param returnObject 返回失败消息对象
	 * @return
	 */
	public static JSONResponse fail(Object returnObject){
		return new JSONResponse(Boolean.FALSE,returnObject,null);
	}
	
	/**
	 * 实例操作失败输出对象，{@code success=false}
	 * 
	 * @param returnObject 返回失败消息对象
	 * @param throwable 异常对象
	 * @return
	 */
	public static JSONResponse fail(Object returnObject,Throwable throwable){
		return new JSONResponse(Boolean.FALSE,returnObject,throwable);
	}
	
	/**
	 * 实例{@link JSONResponse}
	 * 
	 * @param success 操作是否成功
	 * @param returnObject 返回对象
	 * @param throwable 操作异常
	 */
	public JSONResponse(Boolean success,Object returnObject,Throwable throwable){
		this.success = success;
		this.returnObject = returnObject;
		this.throwable = throwable;
	}
	
	/**
	 * 操作成功属性
	 * 
	 * @return
	 */
	public Boolean getSuccess() {
		return success;
	}
	
	/**
	 * 返回操作输出对象值
	 * 
	 * @return
	 */
	public Object getReturnObject() {
		return returnObject;
	}
	
	/**
	 * 返回错误异常描述
	 * 
	 * @return
	 */
	public String getError(){
		return throwable == null ? null :throwable.toString();
	}
}
