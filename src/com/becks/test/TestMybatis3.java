package com.becks.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.becks.entity.Blog;
import com.becks.util.MybatisUtil;

public class TestMybatis3 {

	private SqlSession session;

	@Before
	public void init() throws IOException {
		// 使用上次写的MybaatisUtil工具类，大大简化重复代码
		session = MybatisUtil.getSqlSession();
	}

	@Test
	public void testSelectWrong() {
		System.out.println("＊＊＊＊＊＊测试selectWrong＊＊＊＊＊＊");
		try {
			String statement = "com.becks.mapping.blogMapper.getBlogByIdWrong";// 映射sql的标识字符串
			// 执行查询返回一个唯一blog对象的sql
			Blog blog = session.selectOne(statement, 1);
			if (blog == null) {
				System.out.println("查不到对象，返回对象为空");
			} else {
				System.out.println(blog);
			}
		} finally {
			session.close();
		}
	}

	@Test
	public void testSelectTrue() {
		System.out.println("＊＊＊＊＊＊测试select＊＊＊＊＊＊");
		try {
			String statement = "com.becks.mapping.blogMapper.getBlogById";// 映射sql的标识字符串
			// 执行查询返回一个唯一blog对象的sql
			Blog blog = session.selectOne(statement, 1);
			if (blog == null) {
				System.out.println("查不到对象，返回对象为空");
			} else {
				System.out.println(blog);
			}
		} finally {
			session.close();
		}
	}

	@Test
	public void testSelectResultMap() {
		System.out.println("＊＊＊＊＊＊测试selectResultMap＊＊＊＊＊＊");
		try {
			String statement = "com.becks.mapping.blogMapper.getBlogByIdResultMap";// 映射sql的标识字符串
			// 执行删除一个blog对象的sql
			Blog blog = session.selectOne(statement, 2);
			if (blog == null) {
				System.out.println("查不到对象，返回对象为空");
			} else {
				System.out.println(blog);
			}
		} finally {
			session.close();
		}
	}

}
