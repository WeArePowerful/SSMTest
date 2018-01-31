package edu.gdut.imis.ssmtest.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.gdut.imis.ssmtest.model.User;
import edu.gdut.imis.ssmtest.service.UserService;

/**
 * 配置spring和junit 整合，junit启动时加载springIOC容器spring-test，junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SpringMybatisTest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private User user;
	
	/*@Test
	public void testLogin(){
		//User user = new User();
		user.setUsername("kitty");
		user.setPassword("123456");
		System.out.println(userService.selectLogin(user).toString());
	}*/
	
	/*@Test
	public void testSelectAllUser(){
		List<User> users = userService.selectAllUser();
		for (User us : users) {
			System.out.println(us.toString());
		}
	}*/
	
	/*@Test
	public void testAdd(){
		//User user = new User();
		user.setUsername("user2");
		user.setPassword("123456");
		user.setSex("female");
		user.setAge(25);
		userService.addUser(user);
	}*/
	
	/*@Test
	public void testUpdate(){
		//User user = new User();
		user.setId(2);
		user.setUsername("user2");
		user.setPassword("123");
		user.setSex("female");
		user.setAge(30);
		userService.updateUser(user);
	}*/
	
	@Test
	public void testDelete(){
		int id=2;
		userService.deleteUser(id);
	}
}
