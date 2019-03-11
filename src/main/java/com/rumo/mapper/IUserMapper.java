package com.rumo.mapper;

import org.apache.ibatis.annotations.Param;

import com.rumo.pojo.User;

public interface IUserMapper {
	
	public User getUser(@Param("id")Long id);
	
}
