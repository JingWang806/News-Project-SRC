package com.pb.news.service.impl;

import java.util.List;

import com.pb.news.dao.NewsDao;
import com.pb.news.dao.impl.NewsDaoImpl;
import com.pb.news.entity.News;
import com.pb.news.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsDao newsDao = new NewsDaoImpl();
	

	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	
	public boolean updateNews(News news) {
		return newsDao.update(news);
	}

	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		return newsDao.add(news);
	}

	public boolean deleteNews(int id) {
		// TODO Auto-generated method stub
		 return newsDao.delete(id);
	}

	public List<News> getNewsList() {
		// TODO Auto-generated method stub
		return newsDao.getNewsList();
	}
	public News getOneNews(int id){
		return newsDao.getOneNews(id);
	}

	@Override
	public int getCount() {
		return newsDao.getCount();
	}

	@Override
	public List<News> getSortNews(int page, String str, int index) {
		return newsDao.getSortNews(page, str,index);
	}

	@Override
	public int getCount2() {
		return newsDao.getCount2();
	}
	

}
