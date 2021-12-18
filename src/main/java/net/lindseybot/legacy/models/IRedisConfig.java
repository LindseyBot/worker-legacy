package net.lindseybot.legacy.models;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class IRedisConfig extends GenericObjectPoolConfig<Jedis> {

    public IRedisConfig() {
        // defaults to make your life with connection pool easier :)
        setTestWhileIdle(true);
        setMinEvictableIdleTimeMillis(60000);
        setTimeBetweenEvictionRunsMillis(30000);
        setNumTestsPerEvictionRun(-1);
        setMaxWaitMillis(TimeUnit.SECONDS.toMillis(30));
        setMaxTotal(1000);
    }

}
