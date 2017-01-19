package com.codyy.slr.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * token 管理工作类
 * 
 * @author huangshengda
 *
 */
public class TokenUtils {
	private final static LoadingCache<String, User> tokenCache;

	// 加载类时初始化
	static {
		tokenCache = CacheBuilder.newBuilder().expireAfterAccess(Constants.EXPIRE_TIME, TimeUnit.MINUTES).build(new CacheLoader<String, User>() {
			@Override
			public User load(String key) throws Exception {
				// 在cache中查不到时返回
				User user = new User();
				user.setUserId("0");
				return user;
			}

		});
	}

	/**
	 * 
	 * @Description: 保存user
	 * @param token
	 * @param agent header中的User-Agent
	 * @param user
	 *
	 */
	public static void putUserIdToCache(String token, String agent, User user) {
		tokenCache.put(token + agent, user);
	}

	public static User getUserFromCache(String token, String agent) throws ExecutionException {
		return tokenCache.get(token + agent);
	}

	public static void removeUserFormCache(String token, String agent) throws ExecutionException {
		tokenCache.invalidate(token + agent);
	}
}
