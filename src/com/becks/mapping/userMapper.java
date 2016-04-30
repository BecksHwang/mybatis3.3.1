package com.becks.mapping;

import org.apache.ibatis.annotations.Select;

import com.becks.entity.User;

public interface userMapper {
	  @Select("SELECT * FROM user WHERE id = #{id}")
	  User selectUser(int id);
	}
