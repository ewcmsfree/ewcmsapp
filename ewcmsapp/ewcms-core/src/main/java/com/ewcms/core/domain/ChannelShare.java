/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.core.domain;

/**
 * 频道共享信息对象，站点中频道通过共享可实现不同站点间信息共享。
 *  
 * @author <a href="hhywangwei@gmail.com">wangwei</a>
 */
public class ChannelShare {
	
	/**
	 * 频道共享编号是系统唯一编号
	 */
	private Long id;
	
	/**
	 * 是否共享频道
	 */
	private Boolean share = Boolean.FALSE;
	
	/**
	 * 共享名称，默认频道名称
	 */
	private String shareName;
	
	/**
	 * 是否匿名访问，{@code true}不需要认证访问。
	 */
	private Boolean anonymous = Boolean.FALSE;
	
	/**
	 * 是否写操作，{@code true}可写操作包括新增和修改操作。
	 */
	private Boolean write = Boolean.FALSE;
	
	/**
	 * 是否删除操作，{@code true}可删除操作。
	 */
	private Boolean delete = Boolean.FALSE;
	
	/**
	 * 是否共享子频道，{@code true}共享子频道。
	 */
	private Boolean children = Boolean.FALSE;
	
	/**
	 * 频道共享描述
	 */
	private String describe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getShare() {
		return share;
	}

	public void setShare(Boolean share) {
		this.share = share;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public Boolean getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(Boolean anonymous) {
		this.anonymous = anonymous;
	}

	public Boolean getWrite() {
		return write;
	}

	public void setWrite(Boolean write) {
		this.write = write;
	}

	public Boolean getDelete() {
		return delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public Boolean getChildren() {
		return children;
	}

	public void setChildren(Boolean children) {
		this.children = children;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ChannelShare other = (ChannelShare) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChannelShare [id=").append(id).append(", share=")
				.append(share).append(", shareName=").append(shareName)
				.append(", anonymous=").append(anonymous).append(", write=")
				.append(write).append(", delete=").append(delete)
				.append(",children=").append(children)
				.append(", describe=").append(describe).append("]");
		return builder.toString();
	}
	
}
