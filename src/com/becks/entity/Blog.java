package com.becks.entity;

import java.util.List;

/**
 * @author BecksHwang
 * blog表所对应的实体类
 */
public class Blog {
	
	private int id;//id ==> blog_id
	
	private String name;//name ==> blog_name
	
	private int userId;//userId ==> user_id
	/**
	 * blog表中有一个userId字段，表示一个博客对应一个用户
	 * 所以定义一个user字段，用于维护blog和user之间的一对一关系
	 */	
	private User user;
	/**
	 * List<Article>表示一个Blog有很多篇文章
	 */	
	private List<Article> articles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", userId=" + userId + ", user=" + user + ", articles=" + articles
				+ "]";
	}

}
