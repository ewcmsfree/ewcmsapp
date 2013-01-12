/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.common.mybatis.plugin.dialect;

/**
 * 不支持物理分页查询
 * 
 * @author <a href="hhywangwei@gmail.com">王伟</a>
 */
public class NoneDialect implements LimitDialect{

	@Override
	public boolean isSupports() {
		return false;
	}

	@Override
	public String limit(String sql, int offset, int limit) {
		return sql;
	}
}
