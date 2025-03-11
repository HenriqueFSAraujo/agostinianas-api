package com.agostinianas.demo.core.config;


import com.agostinianas.demo.core.cache.GenericCache;
import com.agostinianas.demo.core.cache.IGenericCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public <K, V> IGenericCache<K, V> getCache(@Value("${app.cache-timeout}") Long cacheTimeout) {
        return (IGenericCache<K, V>) new GenericCache<>(cacheTimeout);
    }
}