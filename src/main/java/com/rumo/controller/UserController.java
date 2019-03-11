package com.rumo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rumo.service.user.IUserService;
import com.rumo.util.JsonUtil;
import com.rumo.vo.ServerResponse;
import com.rumo.vo.UserVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@Api(description="用户管理控制类")
public class UserController {
	
	
	private static final String usernotes = "比如：http://www.xxxx.com/getuser/15074816437";

	@Autowired
	private IUserService userService;
	
	
	//Valid values are {@code path}, {@code query}, {@code body}, {@code header} or {@code form}.
	@ResponseBody
	@GetMapping("/getuser/{id}")
	@ApiOperation(value="根据ID获取用户信息", notes=usernotes)
	/*@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "用户ID", required = true,  dataType = "long", paramType = "path"),
		@ApiImplicitParam(name = "id", value = "用户ID", required = true,  dataType = "long", paramType = "path")
	})*/
	@ApiImplicitParam(name = "id", value = "用户ID", required = true,  dataType = "long", paramType = "path")
	public ServerResponse index(@PathVariable("id")Long id) {
		return userService.getUser(id);
	}
	
	
	//paramType
	//参数传递方式又集中
	
	//第一种 form ----paramType="form"
	//第二种：body :{key:value,key1:value1} paramType="body"
	//第三种：query ?id=1&name=23423 paramType="query"
	//第四种: /getuser/{id}  paramType="path"
	
	@ResponseBody
	@GetMapping("/selectUser")
	@ApiOperation(value="查询用户信息", notes="默认查询pageno= 1代表从第一页开始查询10出来。")
	@ApiImplicitParam(name = "userVo", value = "用户vo", dataType = "UserVo", paramType = "body")
	//@ApiIgnore //忽略接口文档
	public ServerResponse index(UserVo userVo) {
		return userService.selectUsers(userVo);
	}
	
}
