package com.parle.GenericLibary;

import java.util.Date;
import java.util.Random;

public class JavaUtilities {
	public int randomNumber(int p) {
	Random r = new Random();
	 int i = r.nextInt(p);
	 return i; 
	}
	
	
	public String generateDate() {
		Date da = new Date();
		String x[] = da.toString().split(" ");
		return  x[2]+"-"+x[1]+"-"+x[5];
	}
	
	
	public String generateTime() {
		Date dt = new Date();
		String []x = dt.toString().split(" ");
		String time = x[3];
		return time.replace(":", "-");
		
	}
	
	
	public static void main(String[] args) {
		JavaUtilities ju = new JavaUtilities();
		String st = ju.generateDate();
		String ti = ju.generateTime();
		System.out.println(st);
		System.out.println(ti);
	}
	
}
