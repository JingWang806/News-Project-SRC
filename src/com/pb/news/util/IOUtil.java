package com.pb.news.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {
public static void saveFile(OutputStream out,InputStream in){
	BufferedInputStream buffin = null;
	BufferedOutputStream buffout = null;
	buffin = new BufferedInputStream(in);
	buffout = new BufferedOutputStream(out);
	byte[] bytes = new byte[1024];
		try {
			while(buffin.read(bytes)!=-1){
			buffout.write(bytes);
			}
			buffout.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}finally{
		if(buffin!=null){
			try {
				buffin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
}
