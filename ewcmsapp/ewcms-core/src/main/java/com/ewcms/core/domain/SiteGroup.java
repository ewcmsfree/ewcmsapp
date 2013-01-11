/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.core.domain;

import java.util.Date;

/**
 * 系统管理的站群，站群是各类站点的分类，站群可关联形成站群树结构。
 * 
 * @author <a href="hhywangwei@gmail.com">王伟</a>
 */
public class SiteGroup {
	
	/**
	 * 站群编号是在系统中唯一编号
	 */
	private Long Id;
	
	/**
	 * 站群名称
	 */
	private String name;
	
	/**
	 * 站群描述
	 */
	private String describe;
	
	/**
	 * 父站群编号，{@code parentId == null}时为根站群
	 */
	private Long parentId;
	
	/**
	 * 站群创建时间
	 */
	private Date createTime;
	
	/**
	 * 站群修改时间
	 */
	private Date updateTime;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SiteGroup other = (SiteGroup) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SiteGroup [Id=").append(Id).append(", name=")
				.append(name).append(", describe=").append(describe)
				.append(",parentId=").append(parentId)
				.append(", createTime=").append(createTime)
				.append(", updateTime=").append(updateTime).append("]");
		return builder.toString();
	}
}
