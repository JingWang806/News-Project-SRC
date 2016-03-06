package com.pb.news.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.pb.news.dao.BaseDao;

public class Page extends BaseDao {
	private int pageSize;
	private int recordTotalCount;
	private int pageTotalCount;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0){
			this.pageSize = pageSize;
		}
		
	}
	public int getRecordTotalCount() {
		
		
		return recordTotalCount;
	}
	public void setRecordTotalCount(int recordTotalCount) {
		if(recordTotalCount>0){
			this.recordTotalCount = recordTotalCount;
			this.setPageTotalCount(recordTotalCount);
		}
		
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int recordTotalCount) {
		this.pageTotalCount = this.recordTotalCount/pageSize;
	}
	
	public int getStartPageNo(int currPageNo){
		return (currPageNo-1)*pageSize+1;
	}
	
	public int getEndPageNo(int currPageNo){
		return currPageNo*pageSize;
	}
	

}
