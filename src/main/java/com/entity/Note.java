package com.entity;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="notes")
public class Note {
	@Id
	private int id;
	private String tittle;
	@Column(length= 1500)
	private String content;
	private Date addDare;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddDare() {
		return addDare;
	}
	public void setAddDare(Date addDare) {
		this.addDare = addDare;
	}
	public Note( String tittle, String content, Date addDare) {
		super();
		this.id = new Random().nextInt(10000);
		this.tittle = tittle;
		this.content = content;
		this.addDare = addDare;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", tittle=" + tittle + ", content=" + content + ", addDare=" + addDare + "]";
	}
	
	
	
	

}
