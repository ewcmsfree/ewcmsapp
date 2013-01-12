/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.common.mybatis.plugin.dialect;

import org.junit.Assert;
import org.junit.Test;

/**
 * {@link PostgresqlDialect}单元测试
 * 
 * @author <a href="hhywangwei@gmail.com">王伟</a>
 */
public class PostgresqlDialectTest {
	
	@Test
	public void testLimit(){
		
		String sql = "SELECT * FROM t ORDER BY t.ID";
		PostgresqlDialect dialect = new PostgresqlDialect();
		String newSql = dialect.limit(sql, 0, 20);
		String actual = getActual();
		Assert.assertEquals(newSql, actual);
	}
	
	private String getActual(){
		return "SELECT * FROM t ORDER BY t.ID LIMIT 20 OFFSET 0";
	}
}
