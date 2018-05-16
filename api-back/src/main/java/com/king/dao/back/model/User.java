package com.king.dao.back.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 小雷FansUnion-一个有创业和投资经验的资深程序员-全球最大中文IT社区CSDN知名博主-排名第119
 * 博客：http://blog.csdn.net/fansunion
 *
 */
@ApiModel(value = "用户对象", description = "user2")
public class User {

	@ApiModelProperty(value = "商品信息", required = true)
	private String name;
	@ApiModelProperty(value = "密码", required = true)
	private String password;

	@ApiModelProperty(value = "性别",hidden=true)
	private Integer sex;
	@ApiModelProperty(value = "令牌", required = true)
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

}
