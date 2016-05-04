package com.becks.entity;


/**
 *@author BecksHwang
 *article表对应实体类 
 */
public class Article {
	private int id;
	
	private String title;
	
	private int blogId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", blogId=" + blogId + "]";
	}
	
}
