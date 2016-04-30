package com.becks.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.becks.entity.User;

public class TestMybatis {

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
		try{
        	String statement = "com.becks.mapping.userMapper.getUser";//映射sql的标识字符串
        	//执行查询返回一个唯一user对象的sql
        	User user = session.selectOne(statement, 1);
        	System.out.println(user);
        } finally {
        	session.close();
        }
	}
	
	@Test
	public void testInsert() {
		System.out.println("＊＊＊＊＊＊测试insert＊＊＊＊＊＊");
		try{
        	String statement = "com.becks.mapping.userMapper.insertUser";//映射sql的标识字符串
        	//新建user对象用于sql插入
        	User u = new User();
        	u.setName("乔巴");
        	u.setAge(15);
        	int result = session.insert(statement, u);
        	System.out.println(result);
        	session.commit();
        } finally {
        	session.close();
        }
	}
	
	@Test
	public void testDelete() {
		System.out.println("＊＊＊＊＊＊测试delete＊＊＊＊＊＊");
		try{
        	String statement = "com.becks.mapping.userMapper.deleteUser";//映射sql的标识字符串
        	//执行删除一个user对象的sql
        	int result = session.delete(statement, 15);
        	System.out.println(result);
        	session.commit();
        } finally {
        	session.close();
        }
	}
	
	@Test
	public void testUpdate() {
		System.out.println("＊＊＊＊＊＊测试update＊＊＊＊＊＊");
		try{
        	String statement = "com.becks.mapping.userMapper.updateUser";//映射sql的标识字符串
        	User u = new User();
        	u.setId(17);
        	u.setName("乔巴");
        	u.setAge(12);
        	//执行更新user对象的sql
        	int result = session.update(statement, u);
        	System.out.println(result);
        	session.commit();
        } finally {
        	session.close();
        }
	}
	
	@Test
	public void testSelectAll() {
		System.out.println("＊＊＊＊＊＊测试selectAll＊＊＊＊＊＊");
		try{
        	String statement = "com.becks.mapping.userMapper.getAllUser";//映射sql的标识字符串
        	//执行查询所有user对象的sql
        	List<User> result = session.selectList(statement);
        	for (User user : result) {
				System.out.println(user);
			}
        	session.commit();
        } finally {
        	session.close();
        }
	}

}
