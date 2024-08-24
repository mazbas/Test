package com.mphasis.messengerapi.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

    private Integer id;
	
	private String comment;
	
	private Date created;
	
	private String author;
    		
	public Comment() {
		 
	 }


	public Comment(Integer id, String comment,  String author) {
		super();
		this.id = id;
		this.comment = comment;
		this.created = new Date();
		this.author = author;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
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
