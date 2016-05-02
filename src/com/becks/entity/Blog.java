package com.becks.entity;

/**
 * @author BecksHwang
 * blog表所对应的实体类
 */
public class Blog {
	
	private int id;//id ==> blog_id
	
	private String name;//name ==> blog_name
	
	private int userId;//userId ==> user_id

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

	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", userId=" + userId + "]";
	}

}
