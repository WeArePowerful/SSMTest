package edu.gdut.imis.ssmtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.gdut.imis.ssmtest.mapper.UserMapper;
import edu.gdut.imis.ssmtest.model.User;
import edu.gdut.imis.ssmtest.service.UserService;

/**
 * 将当前注释为一个Spring的bean
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	/*
	 * 自动注入UserMapper
	 */
	@Autowired
	public UserMapper userMapper;
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User selectLogin(User user) {
		return userMapper.selectLogin(user);
	}

	@Override
	public List<User> selectAllUser() {
		return userMapper.selectAllUser();
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userMapper.deleteUser(id);
	}

}
