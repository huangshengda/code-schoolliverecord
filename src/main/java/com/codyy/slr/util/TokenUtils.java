package com.codyy.slr.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.codyy.slr.entity.User;
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
	private final static LoadingCache<String,User> tokenCache=CacheBuilder
			.newBuilder().expireAfterAccess(ConfigUtils.getExpireTime(), TimeUnit.SECONDS) 
			.build(new CacheLoader<String, User>(){
				@Override
				public User load(String key) throws Exception {   
					//在cache中查不到时返回
					User user = new User();
					user.setUserId("0");
					return user;
				}
				
			});
	
	
	public static void putUserIdToCache(String token,User user){
		tokenCache.put(token, user);
	}
	
	//如果没找到 返回 tokenStr
	public static User getUserToCache(String token) throws ExecutionException{
		return tokenCache.get(token);
	}
	//测试
	public static void main(String[] args) throws ExecutionException {
		putUserIdToCache("a",new User());
		System.out.println(getUserToCache("a"));
		System.out.println(getUserToCache("b"));
		//System.out.println(getUserToCache(null));
	}
}
