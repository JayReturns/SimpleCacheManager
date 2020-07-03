package com.github.jayreturns.simplecachemanager;

import java.time.Duration;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

public interface CacheManager {
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @param duration
	 * @return
	 */
	public Object cache(CacheKey key, Object value, Duration duration);
	
	default public Object cache(CacheKey key, Object value) {
		return cache(key, value, getDuration());
	}
	
	default Object cache(String key, Object value, Duration duration) {
		return cache(new CacheKey(key), value, duration);
	}
	
	/**
	 * Get the duration for how long to store the data
	 * @return {@linkplain java.time.Duration}
	 */
	public Duration getDuration();
	
	/**
	 * Set the duration for how long to store the data
	 * @param duration {@linkplain java.time.Duration}
	 */
	public void setDuration(Duration duration);
	
	/**
	 * Get the map with all values
	 * @return The map
	 */
	Object2ObjectMap<CacheKey, CacheValue> getCachedMap();
	
}
