package com.becks.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.becks.entity.User;
import com.becks.util.MybatisUtil;

public class TestMybatis4 {

	private SqlSession session;

	@Before
	public void init() throws IOException {
		// 使用上次写的MybatisUtil工具类，大大简化重复代码
		session = MybatisUtil.getSqlSession();
	}

	@Test
	public void testCache() {
		String statement = "com.becks.mapping.userMapper.getUser";
		User user = session.selectOne(statement,1);
		System.out.println(user);
		/*
		 * 一级缓存默认就会被使用
		 */
		user = session.selectOne(statement, 1);
		System.out.println(user);
		session.close();
		/*
		 * 1. 必须是同一个Session,如果session对象已经close()过了就不可能用了
		 */
		session = MybatisUtil.getSqlSession();
		user = session.selectOne(statement, 1);
		System.out.println(user);

		/*
		 * 2. 查询条件是一样的
		 */
		user = session.selectOne(statement, 2);
		System.out.println(user);

		/*
		 * 3. 没有执行过session.clearCache()清理缓存
		 */
		session.clearCache();
		user = session.selectOne(statement, 2);
		System.out.println(user);

		/*
		 * 4. 没有执行过增删改的操作(这些操作都会清理缓存)
		 */
		User u = new User();
    	u.setId(2);
    	u.setName("乌索");
    	u.setAge(18);
		session.update("com.becks.mapping.userMapper.updateUser", u);
		user = session.selectOne(statement, 2);
		System.out.println(user);
	}
	
	@Test
	public void testCache2() {
		String statement = "com.becks.mapping.userMapper.getUser";
		SqlSessionFactory factory = MybatisUtil.getSqlSessionFactory();
		// 开启两个不同的SqlSession
		SqlSession session1 = factory.openSession();
		SqlSession session2 = factory.openSession();
		// 使用二级缓存时，User类必须实现一个Serializable接口===> User implements Serializable
		User user = session1.selectOne(statement, 1);
		session1.commit();// 不懂为啥，这个地方一定要提交事务之后二级缓存才会起作用
		System.out.println("user=" + user);

		// 由于使用的是两个不同的SqlSession对象，所以即使查询条件相同，一级缓存也不会开启使用
		user = session2.selectOne(statement, 1);
		// session2.commit();
		System.out.println("user2=" + user);
	}
	
}
