/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */
package com.ewcms.core.domain;

import java.util.Date;

/**
 * 系统管理的站点，站点必需依赖站群。
 * 
 * @author 周冬初
 *         <a href="hhywangwei@gmail.com">王伟</a>
 */        
public class Site {
	
	/**
	 * 站点编号是站点在系统中唯一编号
	 */
    private Long id;
    
    /**
     * 站点名称
     */
    private String name;
    
    /**
     * 站点描述
     */
    private String describe;
    
    /**
     * 站点访问URL地址 
     */
    private String url;
    
    /**
     * 是否发布站点
     */
    private Boolean release = Boolean.FALSE;
    
    /**
     * 所属站群编号
     */
    private Long siteGroupId;
    
    /**
     * 所属机构信息编号
     */
    private Long organId;
    
    /**
     * 创建时间
     */
    private Date createTime = new Date();
    
    /**
     * 修改时间
     */
    private Date updateTime = new Date();

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

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getRelease() {
		return release;
	}

	public void setRelease(Boolean release) {
		this.release = release;
	}
	
	public Long getSiteGroupId() {
		return siteGroupId;
	}

	public void setSiteGroupId(Long siteGroupId) {
		this.siteGroupId = siteGroupId;
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
		Site other = (Site) obj;
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
		builder.append("Site [id=").append(id).append(", name=").append(name)
				.append(", describe=").append(describe).append(", url=")
				.append(url).append(", release=").append(release)
				.append(",siteGroupId=").append(siteGroupId)
				.append(", createTime=").append(createTime)
				.append(", updateTime=").append(updateTime).append("]");
		return builder.toString();
	}
}
