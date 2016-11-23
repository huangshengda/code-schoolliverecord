package com.codyy.slr.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;

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
	
	private static long EXPIRETIME = 30;

	// 加载类时初始化
	static {
		String expireTime = ConfigUtils.getValue(Constants.EXPIRE_TIME);
		if (StringUtils.isNumeric(expireTime)) {
			EXPIRETIME = Long.parseLong(expireTime);
		}

		tokenCache = CacheBuilder.newBuilder()
				.expireAfterAccess(EXPIRETIME, TimeUnit.MINUTES)
				.build(new CacheLoader<String, User>() {
					@Override
					public User load(String key) throws Exception {
						// 在cache中查不到时返回
						User user = new User();
						user.setUserId("0");
						return user;
					}

				});
	}

	public static void putUserIdToCache(String token, User user) {
		tokenCache.put(token, user);
	}

	public static User getUserToCache(String token) throws ExecutionException {
		return tokenCache.get(token);
	}
}
