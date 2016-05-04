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
		// 使用上次写的MybatisUtil工具类，大大简化重复代码
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
			// 执行查询一个blog对象的sql
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
	
	@Test
	public void testSelectBlogUser1() {
		System.out.println("＊＊＊＊＊＊测试selectBlogUser1＊＊＊＊＊＊");
		try {
			String statement = "com.becks.mapping.blogMapper.getBlog";// 映射sql的标识字符串
			// 执行查询一个blog对象的sql，并带回其对应的user
			Blog blog = session.selectOne(statement, 1);
			if (blog == null) {
				System.out.println("查不到对象，返回对象为空");
			} else {
				System.out.println(blog);
				//查询结果：Blog [id=1, name=香吉士的博客, userId=1, user=User [id=1, name=香吉士, age=12]]
			}
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testSelectBlogUser2() {
		System.out.println("＊＊＊＊＊＊测试selectBlogUser2＊＊＊＊＊＊");
		try {
			String statement = "com.becks.mapping.blogMapper.getBlog2";// 映射sql的标识字符串
			// 执行查询一个blog对象的sql，并带回其对应的user
			Blog blog = session.selectOne(statement, 1);
			if (blog == null) {
				System.out.println("查不到对象，返回对象为空");
			} else {
				System.out.println(blog);
				//查询结果：Blog [id=1, name=香吉士的博客, userId=1, user=User [id=1, name=香吉士, age=12]]
			}
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testSelectBlogAll1() {
		System.out.println("＊＊＊＊＊＊测试testSelectBlogAll1＊＊＊＊＊＊");
		try {
			String statement = "com.becks.mapping.blogMapper.getBlog3";// 映射sql的标识字符串
			// 执行查询一个blog对象的sql，并带回其对应的user
			Blog blog = session.selectOne(statement, 3);
			if (blog == null) {
				System.out.println("查不到对象，返回对象为空");
			} else {
				System.out.println(blog);
				/*查询结果：Blog [id=3, name=索隆的博客, userId=4, user=User [id=4, name=索隆, age=18],
				 *  articles=[Article [id=4, title=索隆的文章1, blogId=3],
				 *  Article [id=5, title=索隆的文章2, blogId=3], 
				 *  Article [id=6, title=索隆的文章3, blogId=3]]]
				 *  */
			}
		} finally {
			session.close();
		}
	}

	@Test
	public void testSelectBlogAll2() {
		System.out.println("＊＊＊＊＊＊测试testSelectBlogAll2＊＊＊＊＊＊");
		try {
			String statement = "com.becks.mapping.blogMapper.getBlog4";// 映射sql的标识字符串
			// 执行查询一个blog对象的sql，并带回其对应的user
			Blog blog = session.selectOne(statement, 3);
			if (blog == null) {
				System.out.println("查不到对象，返回对象为空");
			} else {
				System.out.println(blog);
				/*查询结果：Blog [id=3, name=索隆的博客, userId=4, user=User [id=4, name=索隆, age=18],
				 *  articles=[Article [id=4, title=索隆的文章1, blogId=3],
				 *  Article [id=5, title=索隆的文章2, blogId=3], 
				 *  Article [id=6, title=索隆的文章3, blogId=3]]]
				 *  */
			}
		} finally {
			session.close();
		}
	}
}
