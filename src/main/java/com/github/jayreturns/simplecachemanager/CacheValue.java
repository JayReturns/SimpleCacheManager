package com.github.jayreturns.simplecachemanager;

import java.time.Instant;

import lombok.Data;

@Data
public class CacheValue {

	private final Object value;
	private final Instant cacheTime;
	
}
