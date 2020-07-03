package com.github.jayreturns.simplecachemanager;

import java.time.Duration;
import java.time.Instant;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Getter;
import lombok.Setter;

public class SimpleCacheManager implements CacheManager {

	@Getter
	private Object2ObjectMap<CacheKey, CacheValue> cachedMap = new Object2ObjectOpenHashMap<CacheKey, CacheValue>();

	@Getter @Setter
	private Duration duration = Duration.ofMinutes(30);
	
	@Override
	public Object cache(CacheKey key, Object value, Duration duration) {
		if (cachedMap.containsKey(key)) {
			Instant cachedTime = cachedMap.get(key).getCacheTime();
			if (Duration.between(cachedTime, Instant.now()).abs().compareTo(duration) > 0) {
				cachedMap.remove(key);
				cachedMap.put(key, new CacheValue(value, Instant.now()));
			}
			return cachedMap.get(key);
		}
		cachedMap.put(key, new CacheValue(value, Instant.now()));
		return cachedMap.get(key);
	}
	

}
