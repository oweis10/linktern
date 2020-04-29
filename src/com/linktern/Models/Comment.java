package com.linktern.Models;

import org.springframework.stereotype.Component;

@Component
public class Comment {

	public String content;
	public String userName;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
