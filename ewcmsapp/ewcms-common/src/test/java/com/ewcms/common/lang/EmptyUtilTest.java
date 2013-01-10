/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.common.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * 单元测试{@link EmptyUtil}
 * 
 * @author <a href="hhywangwei@gmail.com">wangwei</a>
 */
public class EmptyUtilTest {

	@Test
	public void testIsNull(){
		Assert.assertTrue(EmptyUtil.isNull(null));
		Assert.assertFalse(EmptyUtil.isNull(new Object()));
	}
	
	@Test
	public void testIsNotNull(){
		Assert.assertTrue(EmptyUtil.isNotNull(new Object()));
		Assert.assertFalse(EmptyUtil.isNotNull(null));
	}
	
	@Test
	public void testIsArrayEmpty(){
		Assert.assertTrue(EmptyUtil.isArrayEmpty(null));
		Assert.assertTrue(EmptyUtil.isArrayEmpty(new Object[0]));
		Assert.assertFalse(EmptyUtil.isArrayEmpty(new Object[1]));
	}
	
	@Test
	public void testIsArrayNotEmpty(){
		Assert.assertTrue(EmptyUtil.isArrayNotEmpty(new Object[1]));
		Assert.assertFalse(EmptyUtil.isArrayNotEmpty(null));
		Assert.assertFalse(EmptyUtil.isArrayNotEmpty(new Object[0]));
	}
	
	@Test
	public void testIsCollectionEmpty(){
		Assert.assertTrue(EmptyUtil.isCollectionEmpty(null));
		List<Object> content = new ArrayList<Object>();
		Assert.assertTrue(EmptyUtil.isCollectionEmpty(content));
		content.add(new Object());
		Assert.assertFalse(EmptyUtil.isCollectionEmpty(content));
	}
	
	@Test
	public void testIsCollectionNotEmpty(){
		List<Object> content = new ArrayList<Object>();
		content.add(new Object());
		Assert.assertTrue(EmptyUtil.isCollectionNotEmpty(content));
		Assert.assertFalse(EmptyUtil.isCollectionNotEmpty(null));
		Assert.assertFalse(EmptyUtil.isCollectionNotEmpty(new ArrayList<Object>(0)));
	}
	
	@Test
	public void testIsMapEmpty(){
		Assert.assertTrue(EmptyUtil.isMapEmpty(null));
		Map<String,String> content = new HashMap<String,String>();
		Assert.assertTrue(EmptyUtil.isMapEmpty(content));
		content.put("1", "2");
		Assert.assertFalse(EmptyUtil.isMapEmpty(content));
	}
	
	@Test
	public void testIsMapNotEmpty(){
		Map<String,String> content = new HashMap<String,String>();
		content.put("1", "2");
		Assert.assertTrue(EmptyUtil.isMapNotEmpty(content));
		Assert.assertFalse(EmptyUtil.isMapNotEmpty(null));
		Assert.assertFalse(EmptyUtil.isMapNotEmpty(new HashMap<Object,Object>()));
	}
	
	@Test
	public void testStringEmpty(){
		Assert.assertTrue(EmptyUtil.isStringEmpty(null));
		Assert.assertTrue(EmptyUtil.isStringEmpty(""));
		Assert.assertTrue(EmptyUtil.isStringEmpty("    "));
		Assert.assertFalse(EmptyUtil.isStringEmpty("1"));
	}
	
	@Test
	public void testStringNotEmpty(){
		Assert.assertFalse(EmptyUtil.isStringNotEmpty(null));
		Assert.assertFalse(EmptyUtil.isStringNotEmpty(""));
		Assert.assertFalse(EmptyUtil.isStringNotEmpty("    "));
		Assert.assertTrue(EmptyUtil.isStringNotEmpty("1"));
	}
}
