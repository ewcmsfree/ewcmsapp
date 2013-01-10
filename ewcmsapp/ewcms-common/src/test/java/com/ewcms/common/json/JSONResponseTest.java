/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.common.json;

import org.junit.Assert;
import org.junit.Test;

import com.ewcms.common.json.JSONResponse;

/**
 * 单元测试{@link JSONResponse}
 * 
 * @author <a href="hhywangwei@gmail.com">wangwei</a>
 */
public class JSONResponseTest {

	@Test
	public void testSuccess(){
		JSONResponse response = JSONResponse.success();
		Assert.assertTrue(response.getSuccess());
		Assert.assertNull(response.getReturnObject());
		Assert.assertNull(response.getError());
	}
	
	@Test
	public void testSuccessInputReturnObject(){
		JSONResponse response = JSONResponse.success("ok");
		Assert.assertTrue(response.getSuccess());
		Assert.assertEquals(response.getReturnObject(),"ok");
		Assert.assertNull(response.getError());
	}
	
	@Test
	public void testFail(){
		JSONResponse response = JSONResponse.fail();
		Assert.assertFalse(response.getSuccess());
		Assert.assertNull(response.getReturnObject());
		Assert.assertNull(response.getError());
	}
	
	@Test
	public void testFailInputReturnObject(){
		JSONResponse response = JSONResponse.fail("error");
		Assert.assertFalse(response.getSuccess());
		Assert.assertEquals(response.getReturnObject(),"error");
		Assert.assertNull(response.getError());
	}
	
	@Test
	public void testFailInputReturnObjectAndException(){
		JSONResponse response = JSONResponse.fail("error",new NullPointerException());
		Assert.assertFalse(response.getSuccess());
		Assert.assertEquals(response.getReturnObject(),"error");
		Assert.assertNotNull(response.getError());
	}
}
