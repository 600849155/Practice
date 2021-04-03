package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/4/3 22:18
 */
public class SimpleRateLimiter {

    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws IOException {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = jedis.pipelined();
        pipe.multi();
        pipe.zadd(key, nowTs, "" + nowTs);
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        return count.get() <= maxCount;
    }

    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis("localhost");
        SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
        for (int i = 0; i < 20; i++) {
            System.out.println(limiter.isActionAllowed("laoqian", "reply", 60, 5));
        }
    }
}

