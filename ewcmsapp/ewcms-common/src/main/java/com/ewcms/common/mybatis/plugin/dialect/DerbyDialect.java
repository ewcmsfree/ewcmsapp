/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.common.mybatis.plugin.dialect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现Derby数据库查询物理分页
 * 
 * @author <a href="hhywangwei@gmail.com">王伟</a>
 */
public class DerbyDialect implements LimitDialect{
	private static final Logger logger = LoggerFactory.getLogger(DerbyDialect.class);
	private static final String SQL_TEMPLATE =
			"SELECT * FROM (SELECT ROW_NUMBER() OVER() AS rownum, rows_.* FROM (%s) AS rows_ ) AS tmp WHERE rownum>%d AND rownum<=%d";
	
	private final String sqlTemplate = SQL_TEMPLATE;
	
	@Override
	public boolean isSupports() {
		return true;
	}
	
	@Override
	public String limit(String sql, int offset, int limit) {
		
		final int from = offset;
		final int to = offset + limit;
		String newSql = String.format(sqlTemplate, sql,from,to);
		logger.debug("Derby's pagination sql is {}",newSql);
		
		return newSql;
	}
}
