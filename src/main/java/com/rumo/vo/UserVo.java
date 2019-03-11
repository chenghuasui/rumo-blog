package com.rumo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

@ApiModel(description="用户搜索实体VO类")
public class UserVo {
	
	//User UserVo dubbo
	
	//front admin ge
	@ApiModelProperty(required=false,value="根据用户名，邮箱搜索用户信息，比如：kek /15564545@qq.com")
	private String keyword;
	@ApiModelProperty(required=false,value="用户名")
	private String username;
	@ApiModelProperty(required=false,value="分页pageno默认是1")
	private Integer pageNo = 1;
	@ApiModelProperty(required=false,value="分页每次查询的记录数，默认是：10")
	private Integer pageSize = 10;
	@ApiModelProperty(required=false,value="发布状态：默认1 ，1发布的，0未发布")
	private Integer status = 1;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
