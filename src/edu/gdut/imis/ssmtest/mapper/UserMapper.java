package edu.gdut.imis.ssmtest.mapper;

import java.util.List;

import edu.gdut.imis.ssmtest.model.User;

public interface UserMapper {
	
	/**
	 * 用户登录查询
	 * @param user
	 * @return User
	 */
	public User selectLogin(User user);
	
	/**
	 * 查询全部用户
	 * @return List<User>
	 */
	public List<User> selectAllUser();
	
	/**
	 * 新增用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	public void deleteUser(Integer id);
}
