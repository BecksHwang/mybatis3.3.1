package com.becks.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.becks.entity.User;
import com.becks.mapping.userMapper;



public class Test {

    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "conf.xml";
        //使用输入流加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        //InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
        //使用输入流实例构建SqlsessionFactory实例
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //SqlSessionFactory创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 使用完全限定命xml文件映射sql的标识字符串，
         * com.becks.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        try{
        	String statement = "com.becks.mapping.userMapper.getUser";//映射sql的标识字符串
        	//执行查询返回一个唯一user对象的sql
        	User user = session.selectOne(statement, 2);
        	System.out.println(user);
        } finally {
        	session.close();
        }
        /**
         * 使用java中的注解映射sql语句
         * 映射不基于字符串常量，更安全
         * 不用担心易错的字符串字面值以及强制类型转换
         * 不适用于复杂的sql语句
         */  
//        try {
//          UserMapper mapper = session.getMapper(UserMapper.class);
//          User user = mapper.selectUser(1);
//          System.out.println(user);
//        } finally {
//          session.close();
//        }
    }
}