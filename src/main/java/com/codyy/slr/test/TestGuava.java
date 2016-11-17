package com.codyy.slr.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class TestGuava {
	
	final static LoadingCache<String,String> cahceBuilder=CacheBuilder
			.newBuilder().expireAfterAccess(4, TimeUnit.SECONDS) 
			.build(new CacheLoader<String, String>(){
				@Override
				public String load(String key) throws Exception {        
					return "0";
				}
				
			});
			
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		  cahceBuilder.put("harry", "ssdded");
		  System.out.println(cahceBuilder.get("harry"));
		  System.out.println(cahceBuilder.get("aa"));
		  System.out.println(cahceBuilder.get("aa"));
		  System.out.println(cahceBuilder.get("dsad"));
		  Thread.currentThread().sleep(1000);
		 // System.out.println(cahceBuilder.get("harry"));
		  Thread.currentThread().sleep(3000);
		  System.out.println(cahceBuilder.get("harry"));
	}
			      

	
	LoadingCache<String, String> tokens = CacheBuilder.newBuilder()
			
			        .expireAfterWrite(10, TimeUnit.MINUTES)
			
			        .removalListener(null)
			
			        .build(
			
			            new CacheLoader<String, String>() {
			
							@Override
							public String load(String arg0) throws Exception {
								// TODO Auto-generated method stub
								return null;
							}
			
			        });
	
	  @Test
	    public void TestLoadingCache() throws Exception{
	        LoadingCache<String,String> cahceBuilder=CacheBuilder
	        .newBuilder()
	        .build(new CacheLoader<String, String>(){
	            @Override
	            public String load(String key) throws Exception {        
	                String strProValue="hello "+key+"!";                
	                return strProValue;
	            }
	            
	        });
	        System.out.println("jerry value:"+cahceBuilder.apply("jerry"));
	        System.out.println("jerry value:"+cahceBuilder.get("jerry"));
	        System.out.println("peida value:"+cahceBuilder.get("peida"));
	        System.out.println("peida value:"+cahceBuilder.apply("peida"));
	        System.out.println("lisa value:"+cahceBuilder.apply("lisa"));
	        cahceBuilder.put("harry", "ssdded");
	        System.out.println("harry value:"+cahceBuilder.get("harry"));
	  }
}
