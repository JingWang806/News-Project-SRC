package com.pb.news.dao;

import java.util.Date;
import java.util.List;

import com.pb.news.entity.News;


public interface NewsDao {
	
	public List<News> getNewsList();

	
	public boolean add(News news) ;
	
	
	public boolean delete(int id) ;
	
	
	public boolean update(News news) ;
	
	
	public News getOneNews(int id);
	
	
	public int getCount();
	
	
	public List<News> getSortNews(int page,String str,int index);
	
	public int getCount2();
	
//	public List<News> getInlandNews();
	

}
