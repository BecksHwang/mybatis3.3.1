package com.becks.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.becks.entity.User;
import com.becks.mapping.UserMapperI;

public class TestMybatis2 {

	private SqlSession session;
	
	@Before
	public void init(){
		//mybatis的配置文件
        String resource = "conf.xml";
        //使用输入流加载配置文件
        InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			//使用输入流实例构建SqlsessionFactory实例
	        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	        //SqlSessionFactory创建能执行映射文件中sql的sqlSession
	         session = sessionFactory.openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	@Test
	public void testSelect() {
		System.out.println("＊＊＊＊＊＊测试select＊＊＊＊＊＊");
		try {
			UserMapperI mapper = session.getMapper(UserMapperI.class);
			User user = mapper.selectUser(1);
			System.out.println(user);
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testInsert() {
		System.out.println("＊＊＊＊＊＊测试insert＊＊＊＊＊＊");
		try {
			UserMapperI mapper = session.getMapper(UserMapperI.class);
			User u = new User();
        	u.setName("布鲁");
        	u.setAge(50);
			int i = mapper.insertUser(u);
			System.out.println(i);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testDelete() {
		System.out.println("＊＊＊＊＊＊测试delete＊＊＊＊＊＊");
		try {
			UserMapperI mapper = session.getMapper(UserMapperI.class);
			int i = mapper.deleteUser(9);
			System.out.println(i);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testUpdate() {
		System.out.println("＊＊＊＊＊＊测试update＊＊＊＊＊＊");
		try {
			UserMapperI mapper = session.getMapper(UserMapperI.class);
			User u = new User();
			u.setId(10);
        	u.setName("布鲁克");
        	u.setAge(15);
			int i = mapper.updateUser(u);
			System.out.println(i);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testSelectAll() {
		System.out.println("＊＊＊＊＊＊测试selectAll＊＊＊＊＊＊");
		try{
			UserMapperI mapper = session.getMapper(UserMapperI.class);
			List<User> result = mapper.selectAllUser();
			for (User user : result) {
				System.out.println(user);
			}
        } finally {
        	session.close();
        }
	}

}
