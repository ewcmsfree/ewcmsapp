/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.common.mybatis.plugin.dialect;

/**
 * 数据库物理分页接口
 * 
 * @author wangwei
 */
public interface LimitDialect {

	/**
	 * 是否支持物理分页查询
	 * 
	 * @return
	 */
	boolean isSupports();
	
	/**
	 * 得到分页查询的sql语句
	 * 
	 * @param sql 查询sql语句
	 * @param offset 查询偏移记录数
	 * @param limit 查询记录数
	 * @return
	 */
	String limit(String sql,int offset,int limit);
}
