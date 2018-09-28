package com.boot.security.server.service;

import com.boot.security.server.dto.UserDto;
import com.boot.security.server.model.SysUser;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

	SysUser saveUser(UserDto userDto);

	SysUser updateUser(UserDto userDto);

	SysUser getUser(String username);

	void changePassword(String username, String oldPassword, String newPassword);

	SysUser getTokenUser(HttpServletRequest request);

}
