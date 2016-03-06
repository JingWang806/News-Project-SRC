package com.pb.news.entity;

import java.util.Date;

import com.pb.news.service.NewsService;
import com.pb.news.service.impl.NewsServiceImpl;

//JavaBean
public class News {
	//Attribute
    private int id;
	private int categoryId;
	private String title;
	private String summary;
	private String content;
	private String picPath;
	private String author;
	private Date createDate;
	private Date modifyDate;
	private int totalPageCount = 1;
	private int pageSize = 4;
	private int recordCount = 0;
	//setter&getter
	public News(String str,int index){
		this.setTotalPageCountByRs();
	}
	public int getId() {
		return id;
	}
	public News(int categoryId, String title, String summary,
			String content, String author, Date createDate,String str,int index) {
		super();
		this.setTotalPageCountByRs();
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.author = author;
		this.createDate = createDate;
	}
	
	public News(){
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.author = author;
		this.createDate = createDate;
		this.totalPageCount = totalPageCount;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setTotalPageCountByRs(){
		NewsService service = new NewsServiceImpl();
		recordCount = service.getCount();
		if(recordCount%pageSize==0){
			totalPageCount = recordCount/pageSize;
		}
		else{
			totalPageCount = recordCount/pageSize+1;
			}
		
	}
	
	
	
}
