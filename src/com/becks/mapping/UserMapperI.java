package com.becks.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.becks.entity.User;
/*
 * @author BecksHwang
 * 定义sql映射接口，使用注解的方式指明要执行的sql
 * */
public interface UserMapperI {
	
	//使用@Select注解指明selectUser要执行的sql	
	@Select("select * from user where id = #{id}")
	public User selectUser(int id);
	
	//使用@Insert注解指明insertUser要执行的sql
	@Insert("insert into user(name,age) values(#{name},#{age})")
	public int insertUser(User user);
	
	//使用@Update注解指明updateUser要执行的sql	
	@Update("update user set name=#{name},age=#{age} where id=#{id}")
	public int updateUser(User user);
	
	//使用@Delete注解指明deleteUser要执行的sql
	@Delete("delete from user where id=#{id}")
	public int deleteUser(int id);
	
	//使用@Select注解指明selectAllUser要执行的sql
	@Select("select * from user")
	public List<User> selectAllUser();
	
	}
