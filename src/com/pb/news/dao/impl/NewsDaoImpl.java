package com.pb.news.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.CallableStatement;
import com.pb.news.dao.BaseDao;
import com.pb.news.dao.NewsDao;
import com.pb.news.entity.News;
import com.pb.news.util.ConfigManager;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	// Search out one news
	public News getOneNews(int id){
		News news = null;
		String sql="select * from news_detail where id=?";
		Object[] params={id};
		ResultSet rs = this.executeSQL(sql, params);
		int categoryId;
		
		try {
			if(rs.next()){
			categoryId = rs.getInt("categoryId");
			String title=rs.getString("title");
			String summary=rs.getString("summary");
			String content=rs.getString("content");
			String author=rs.getString("author");
			Date time=rs.getDate("createdate");
			String picPath=rs.getString("picpath");
			 news=new News(categoryId,title,summary,content,author,time,"",0);
				news.setId(id);
				news.setPicPath(picPath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		//Encapsulate the news
	
		return news;
	}
	
    //Search the News List
	public List<News> getNewsList(){
		List<News> newList=new ArrayList<News>();
		try {
			
			String sql="select * from news_detail";
			Object[] params={};
			ResultSet rs=this.executeSQL(sql, params);
			
			while(rs.next()){
				int id = rs.getInt("id");
				int categoryId=rs.getInt("categoryId");
				String title=rs.getString("title");
				String summary=rs.getString("summary");
				String content=rs.getString("content");
				String author=rs.getString("author");
				Date time=rs.getDate("createdate");
				
				//Encapsulate into News Object
				News news=new News(categoryId,title,summary,content,author,time,"",0);
				news.setId(id);
				
				newList.add(news);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//release the resource
			this.closeResource();
		}
		return newList;
	}

	// Add news
	public boolean add(News news) {
		boolean flag=false;
		try {
			String sql="insert into news_detail(id,categoryId,title,summary,content,author,createdate,picPath) values(?,?,?,?,?,?,?,?)";
			Object[] params={news.getId(),news.getCategoryId(),news.getTitle(),news.getSummary(),news.getContent(),
					news.getAuthor(), new Timestamp(news.getCreateDate().getTime()),news.getPicPath()};
			int i=this.executeUpdate(sql, params);
			
			if(i>0){
				System.out.println("Insert News Successful！");
			}
			flag=true;
		}finally{

			this.closeResource();
		}
		return flag;
	}
	
	// Delete news
	public boolean delete(int id) {
		boolean flag=false;
		try {
			String sql = "delete from news_detail where id=?";
			Object[] params={id};
			int i=this.executeUpdate(sql, params);
		
			if(i>0){
				System.out.println("Delete News Successful！");
			}
			flag=true;
		}  finally {
	
			this.closeResource();
		}
		return flag;
	}

	// Modify the news
	public boolean update(News news) {
		boolean flag=false;
		try {
			String sql = "update news_detail set categoryId=? , title=?, summary=? , content=?, picpath=?"
		             +",author=? ,modifydate=? where id=?";
			Object[] params={news.getCategoryId(),news.getTitle(),news.getSummary(),news.getContent(),news.getPicPath(),news.getAuthor(),new Timestamp(news.getModifyDate().getTime()),news.getId()};
			int i=this.executeUpdate(sql, params);
			
			if(i>0){
				System.out.println("Modify Successful！");
			}
			flag=true;
		}  finally {
			
			this.closeResource();
		}
		return flag;
	}
	
	//Total News
	@Override
	public int getCount() {
		
		String sql="select count(*) from news_detail";
		Object[] params ={};
		int count = 0;
		ResultSet rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		
		return count;
	}
	
	public List<News> getSortNews(int page,String str, int index) {
		List<News> list = new ArrayList<News>();
		News news = new News("",0);
		int pageSize = news.getPageSize();
		String s="";
		if(index!=0){
			s=""+index;		}
		String sql = "select * from news_detail limit ?,"+pageSize;
		
		
		Object[] params = {(page-1)*pageSize};
		ResultSet rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				news = new News("",0);
				int id = rs.getInt("id");
				int categoryId=rs.getInt("categoryId");
				String title=rs.getString("title");
				String summary=rs.getString("summary");
				String content=rs.getString("content");
				String author=rs.getString("author");
				Date time = rs.getDate("createdate");
				
				news.setId(id);
				news.setAuthor(author);
				news.setCategoryId(categoryId);
				news.setContent(content);
				news.setSummary(summary);
				news.setTitle(title);
				news.setCreateDate(time);
				
				list.add(news);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return list;
	}
	
	
	@Override
	public int getCount2() {
		int totalCount=0;
		getConnection();
		CallableStatement callableStatement = null;
		String sql = "{call proc3(?,?)}";
		try {
			callableStatement = (CallableStatement) conn.prepareCall(sql);
			callableStatement.setInt(1, 1);
			callableStatement.registerOutParameter(2, Types.INTEGER);
			callableStatement.execute();
			totalCount = callableStatement.getInt(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}



}
