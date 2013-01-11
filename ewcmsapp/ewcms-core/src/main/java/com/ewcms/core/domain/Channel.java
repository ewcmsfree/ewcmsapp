/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */

package com.ewcms.core.domain;

import java.util.Date;

/**
 * 站点频道依赖站点，站点内容依赖于频道，可关联形成频道树结构。
 * 
 * @author 周冬初 wuzhijun
 *         <a href="hhywangwei@gmail.com">王伟</a>
 */
public class Channel {
	
	/**
	 * 频道编号系统唯一编号 
	 */
	private Long id;
	
	/**
	 * 频道名称 
	 */
	private String name;
	
	/**
	 * 访问地址
	 */
	private String url;
	
	/**
	 * 在本级顺序位置，数字越小优先级越高
	 */
	private Integer order = 0;
	
	/**
	 * 是否发布频道
	 */
	private Boolean release = Boolean.FALSE;
	
	/**
	 * 是否共享频道
	 */
	private Boolean share = Boolean.FALSE;
	
	/**
	 * 父频道编号，@{code parentId == null}为根频道
	 */
	private Long parentId;
	
	/**
     * 所属机构信息编号
     */
	private Long organId;
	
	/**
	 * 所属站点编号
	 */
	private Long siteId;
	
	/**
	 * 频道描述
	 */
	private String describe;
	
	/**
	 * 频道创建时间
	 */
	private Date createTime;
	
	/**
	 * 频道修改时间
	 */
	private Date updateTime;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer getSort() {
		return order;
	}
	
	public void setSort(Integer sort) {
		this.order = sort;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public Boolean getRelease() {
		return release;
	}
	
	public void setRelease(Boolean release) {
		this.release = release;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Boolean getShare() {
		return share;
	}

	public void setShare(Boolean share) {
		this.share = share;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getOrganId() {
		return organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
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
		Channel other = (Channel) obj;
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
		builder.append("Channel [id=").append(id).append(", name=")
				.append(name).append(", url=").append(url).append(", order=")
				.append(order).append(", release=").append(release)
				.append(", share=").append(share).append(", parentId=")
				.append(parentId).append(", organId=").append(organId)
				.append(", siteId=").append(siteId).append(", describe=")
				.append(describe).append(", createTime=").append(createTime)
				.append(", updateTime=").append(updateTime).append("]");
		return builder.toString();
	}
}
