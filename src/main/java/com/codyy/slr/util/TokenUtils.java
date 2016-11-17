package com.codyy.slr.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * token 管理工作类
 * @author huangshengda
 *
 */
public class TokenUtils {
	
	//加载类时初始化
	private final static LoadingCache<String,String> tokenCache=CacheBuilder
			.newBuilder().expireAfterAccess(ConfigUtils.getExpireTime(), TimeUnit.SECONDS) 
			.build(new CacheLoader<String, String>(){
				@Override
				public String load(String key) throws Exception {   
					//在cache中查不到时返回
					return "0";
				}
				
			});
	
	
	public static void putUserIdToCache(String token,String userId){
		tokenCache.put("token_" + token, "userId_" + userId);
	}
	
	//如果没找到 返回 tokenStr
	public static String getUserToCache(String token) throws ExecutionException{
		String userId = tokenCache.get("token_" + token);
		if(StringUtils.isNotEmpty(userId) && !"0".equals(userId)){
			userId = userId.substring(userId.indexOf("_")+1);
		}
		return userId;
	}
	//测试
	public static void main(String[] args) throws ExecutionException {
		putUserIdToCache("a","11");
		System.out.println(getUserToCache("a"));
		System.out.println(getUserToCache("b"));
	}
}
