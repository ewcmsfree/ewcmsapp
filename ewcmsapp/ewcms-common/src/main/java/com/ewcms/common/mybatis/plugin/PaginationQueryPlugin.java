/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.common.mybatis.plugin;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ewcms.common.mybatis.plugin.dialect.DerbyDialect;
import com.ewcms.common.mybatis.plugin.dialect.LimitDialect;
import com.ewcms.common.mybatis.plugin.dialect.NoneDialect;
import com.ewcms.common.mybatis.plugin.dialect.OracleDialect;
import com.ewcms.common.mybatis.plugin.dialect.PostgresqlDialect;

/**
 * 数据库物理查询分页插件，适用于{@code Mybatis}框架。
 * 
 * @author <a href="hhywangwei@gmail.com">王伟</a>
 */
@Intercepts({@Signature(
		type=Executor.class,
		method="query",
		args={MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})})
public class PaginationQueryPlugin implements Interceptor {
	private static final Logger logger = LoggerFactory.getLogger(PaginationQueryPlugin.class);
	private static final int MAPPED_STATEMENT_ARGS_INDEX = 0;
	private static final int PARAMETER_ARGS_INDEX = 1;
	private static final int ROWBOUNDS_ARGS_INDEX = 2;
	private static final String DIALECT_PARAM_NAME = "dialect";
	
	private final Map<String,LimitDialect> dialects;
	private LimitDialect dialect = new NoneDialect();
	
	public PaginationQueryPlugin(){
		dialects = new Hashtable<String,LimitDialect>();
		dialects.put("postgresql", new PostgresqlDialect());
		dialects.put("oracle", new OracleDialect());
		dialects.put("derby", new DerbyDialect());
	}
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		RowBounds rowBounds = (RowBounds)invocation.getArgs()[ROWBOUNDS_ARGS_INDEX];
		if(noPagination(dialect,rowBounds)){
			return invocation.proceed();
		}
		
		MappedStatement statement = (MappedStatement)invocation.getArgs()[MAPPED_STATEMENT_ARGS_INDEX];
		Object parameter = invocation.getArgs()[PARAMETER_ARGS_INDEX];
		BoundSql boundSql = statement.getBoundSql(parameter);
		if(StringUtils.isNotBlank(boundSql.getSql())){
			logger.warn("query boundsql is null");
			return null;
		}
		
		invocation.getArgs()[MAPPED_STATEMENT_ARGS_INDEX] = 
				newMappedStatement(statement,boundSql,rowBounds);
		invocation.getArgs()[ROWBOUNDS_ARGS_INDEX] = new RowBounds();
		
		return invocation.proceed();
	}
	
	/**
	 * 判断不需要分页
	 * 
	 * @param dialect 
	 * @param rowBounds 
	 * @return
	 */
	private boolean noPagination(LimitDialect dialect,RowBounds rowBounds){
		return !(dialect.isSupports() && rowBounds.getLimit() > 0
				&& rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT); 
	}
	
	/**
	 * 创建一个可以实现分页查询的{@link MppedStatement}
	 * 
	 * @param statement 
	 * @param boundSql 
	 * @param rowBounds
	 * @return
	 */
	private MappedStatement newMappedStatement(final MappedStatement statement,
			final BoundSql boundSql,final RowBounds rowBounds){
		
		setPagination(boundSql,rowBounds);
		Builder builder = new MappedStatement.Builder(
				statement.getConfiguration(), statement.getId(),
				new SqlSource(){
					@Override
					public BoundSql getBoundSql(Object parameterObject) {
						return boundSql;
					}				
				},
				statement.getSqlCommandType())
		        .cache(statement.getCache())
		        .databaseId(statement.getDatabaseId())
		        .fetchSize(statement.getFetchSize())
		        .keyColumn(arrayToCommaDelimitedString(statement.getKeyColumns()))
		        .keyGenerator(statement.getKeyGenerator())
		        .keyProperty(arrayToCommaDelimitedString(statement.getKeyProperties()))
		        .parameterMap(statement.getParameterMap())
		        .resource(statement.getResource())
		        .resultMaps(statement.getResultMaps())
		        .statementType(statement.getStatementType())
		        .timeout(statement.getTimeout())
		        .useCache(statement.isUseCache());
		
		return builder.build();
	}
	
	/**
	 * 生成分页语句，设置到{@link BoundSql}对象中
	 * 
	 * @param BoundSql  
	 * @param rowBounds 
	 */
	private void setPagination(BoundSql boundSql,RowBounds rowBounds){
		String sql = dialect.limit(boundSql.getSql(), 
				rowBounds.getOffset(), rowBounds.getLimit());
		MetaObject.forObject(boundSql).setValue("sql", sql);
	    logger.debug("BoundSql sql is {}",boundSql.getSql());
	}
	
	/**
	 * 数组转换为以{@code 逗号（,）}分给的字符串
	 * 
	 * @param values 数组值
	 * @return
	 */
	private String arrayToCommaDelimitedString(String[] values){
		return StringUtils.join(values,",");
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		setDialect(properties);
	}
	
	/**
	 * 设置支持数据方言
	 * 
	 * @param properties
	 */
	private void setDialect(Properties properties){
		String value = properties.getProperty(DIALECT_PARAM_NAME);
		if(StringUtils.isBlank(value)){
			return ;
		}
		dialect = dialects.get(value);
		if(dialect == null){
			String types = dialects.keySet().toString();
			logger.error("Dialect only can {}",types);
			throw new IllegalArgumentException("Dialect only can " + types);
		}
	}

	/**
	 * 得到设置的数据方言
	 * 
	 * @return
	 */
	public LimitDialect getDialect(){
		return dialect;
	}
}
