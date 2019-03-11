package com.rumo.service.user;

import com.rumo.vo.ServerResponse;
import com.rumo.vo.UserVo;

public interface IUserService {
	
	public ServerResponse getUser(Long id);
	public ServerResponse selectUsers(UserVo userVo);
}
