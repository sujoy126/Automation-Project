package com.parle.GenericLibary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtill {
	public String propertyFetch(String path, String key) {
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties pobj = new Properties();
		try {
			pobj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pobj.getProperty(key);
	}

}









