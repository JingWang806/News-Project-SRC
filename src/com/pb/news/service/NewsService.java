package com.pb.news.service;

import java.util.List;

import com.pb.news.entity.News;

public interface NewsService {
	
	public boolean updateNews(News news);
	
	public boolean addNews(News news);	
	
	public boolean deleteNews(int id);
	
	public List<News> getNewsList();
	
	public News getOneNews(int id);
	
	public int getCount();

	public List<News> getSortNews(int page,String str,int index);
	
	public int getCount2();
}
