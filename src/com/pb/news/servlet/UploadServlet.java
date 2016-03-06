package com.pb.news.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UploadServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items;
		try {
			items = upload.parseRequest(request);
			for(int i=0;i<items.size();i++){
				FileItem item = items.get(i);
				if(item.isFormField()){
					String filename = item.getFieldName();
				}else{
					String filename = item.getName();
					File file = new File("/Users/jingwang/Documents/meta/wtpwebapps/news/upload/"+filename);
					if(!file.exists()){
					file.createNewFile();
					}
					try {
						item.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					}
				}
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		}
		
		}
	}


	@Override
	public void destroy() {
		super.destroy();
	}


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	

}
