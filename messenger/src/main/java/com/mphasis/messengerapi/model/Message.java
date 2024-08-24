package com.mphasis.messengerapi.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.json.bind.annotation.JsonbTransient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	
	private Integer id;
	
	private String messsage;
	
	private Date created;
	
	private String author;
	
	private Map<Integer,Comment> comments = new LinkedHashMap<Integer,Comment>();
	
	
	//@JsonbTransient
	@XmlTransient
	public Map<Integer, Comment> getComments() {
		return comments;
	}


	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}
	
	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(Integer id, String messsage, String author) {
		this.id = id;
		this.messsage = messsage;
		this.created = new Date();
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMesssage() {
		return messsage;
	}

	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
