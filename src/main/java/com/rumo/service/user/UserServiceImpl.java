package com.rumo.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rumo.mapper.IUserMapper;
import com.rumo.pojo.User;
import com.rumo.vo.ResponseCode;
import com.rumo.vo.ServerResponse;
import com.rumo.vo.UserVo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	public IUserMapper userMapper;
	
	
	@Override
	public ServerResponse getUser(Long id) {
		User user = userMapper.getUser(id);
		return ServerResponse.createBySuccess(user);
	}


	@Override
	public ServerResponse selectUsers(UserVo userVo) {
		return ServerResponse.createByError(ResponseCode.SERVER_ERROR);
	}

}
