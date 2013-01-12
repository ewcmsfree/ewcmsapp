/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.common.mybatis.plugin.dialect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现Postgresql数据查询物理分页
 * 
 * @author <a href="hhywangwei@gmail.com">王伟</a>
 */
public class PostgresqlDialect implements LimitDialect{
	private static final Logger logger = LoggerFactory.getLogger(PostgresqlDialect.class);
	private static final String SQL_TEMPLATE = "%s LIMIT %d OFFSET %d";

	private final String sqlTemplate = SQL_TEMPLATE;
	
	@Override
	public boolean isSupports() {
		return true;
	}

	@Override
	public String limit(String sql, int offset, int limit) {
		
		String newSql = String.format(sqlTemplate, sql,limit,offset);
		logger.debug("Postgresql's pagination sql is {}",newSql);
		
		return newSql;
	}
}
