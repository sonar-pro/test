package com.cib.entity;

public class Page_bak {

	public Page_bak(){}
	
	
	/*
	 * @return int  返回 丄1�7共有多少顄1�7
	 * @param pageSize 每页的数据条敄1�7
	 * @param count 丄1�7共多少条数据
	 */
	public static int pageCount(int pageSize,int count){
		
		int i=count%pageSize; //判断是否整除
		
		int j=(count-i)/pageSize;
		
		if(i>0){//如果不整除�1�7�页数就加一
          j=j+1;			
		}
		
		return j;
	}
	
	
}
