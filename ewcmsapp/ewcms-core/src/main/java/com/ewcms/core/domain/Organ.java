/**
 * Copyright (c)2010-2011 Enterprise Website Content Management System(EWCMS), All rights reserved.
 * EWCMS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.ewcms.com
 */

/**
 * 
 */
package com.ewcms.core.domain;

/**
 * 机构信息对象，站点或频道内容管理和维护机构信息
 * 
 * @author 周冬初
 *         <a href="hhywangwei@gmail.com">王伟</a>
 */
public class Organ {
	
	/**
	 * 机构编号系统唯一编号
	 */
    private Long id;	
    
    /**
     * 机构名称
     */
    private String name;
    
    /**
     * 机构地址
     */
    private String address;
    
    /**
     * 邮编
     */
    private String postcode;
    
    /**
     * 联系电话号码
     */
    private String phone;
    
    /**
     * 联系邮件
     */
    private String email;
    
    /**
     * 交通方式
     */
    private String way;
    
    /**
     * 服务时间
     */
    private String serviceTime;
    
    /**
     * 经度 提供地图使用（如:google map)
     */
    private String latitude;
    
    /**
     * 纬度 提供地图使用（如:google map)
     */
    private String longitude;
    
    /**
     * 机构介绍
     */
    private String describe;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
		Organ other = (Organ) obj;
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
		builder.append("Organ [id=").append(id).append(", name=")
				.append(name).append(", address=").append(address)
				.append(", postcode=").append(postcode).append(", phone=")
				.append(phone).append(", email=").append(email)
				.append(", way=").append(way).append(", serviceTime=")
				.append(serviceTime).append(", latitude=").append(latitude)
				.append(", longitude=").append(longitude).append(", describe=")
				.append(describe).append("]");
		return builder.toString();
	}
}
