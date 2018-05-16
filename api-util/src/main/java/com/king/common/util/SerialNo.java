package com.king.common.util;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

public class SerialNo {
	
	private static RedisTemplate<String, Object> redisTemplate;

	public SerialNo() {
	}

	public static synchronized String getUNID() {
		String currentTime = DateUtil.getCurrentDateString("yyMMddHHmmssSSS");
		return (new StringBuilder(String.valueOf(currentTime))).append(RandomStringUtils.randomNumeric(5)).toString();
	}

	public static synchronized String getSmallUNID(String code) {
		String currentTime = "";

		if (StringUtils.isBlank(code) || code.length() < 4) {
			currentTime = DateUtil.getCurrentDateString("yyMMddHHmmssSSS");
		} else {
			try {
				// 取消掉除了数字以外的其他情况
				String number = Integer.valueOf(code).toString();
				currentTime = number.substring(0, 4) + DateUtil.getCurrentDateString("yyHHmmssSSS");
			} catch (Exception e) {
				currentTime = DateUtil.getCurrentDateString("yyMMddHHmmssSSS");
			}

		}
		return (new StringBuilder(String.valueOf(currentTime))).append(RandomStringUtils.randomNumeric(4)).toString();

	}

	public static synchronized Integer getRomdomID() {
		return Integer.parseInt(RandomStringUtils.randomNumeric(6));
	}
	
	public static synchronized Long getRomdomLongID() {
		return Long.valueOf(RandomStringUtils.randomNumeric(11));
	}

	public static synchronized String createContractNo(String stampPrix) {
/*		String prix = "6770";
		String currentDay = DateUtil.getStringDateShort().replaceAll("-", "");
		final String cacheKey = prix + stampPrix + ":" + currentDay;
		StringBuffer contractNo = new StringBuffer(stampPrix + "-");
		DecimalFormat df = new DecimalFormat("0000");
		contractNo.append(currentDay);
		long count = redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.incrBy(cacheKey.getBytes(),1);
            }
        });
		
		
		log.info("获取电子签章流水计数器,cacheKey:" + cacheKey + ",seq:" + count);
		if (count == 1) {
			redisTemplate.execute(new RedisCallback() {
	            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
	                return connection.expire(cacheKey.getBytes(), 60 * 60 * 24);
	            }
	        });
		}
		contractNo.append(df.format(count));
		log.info("电子签章流水号：" + contractNo);
		return contractNo.toString();*/
		return "";
	}

	public static void main(String[] args) {
		System.err.println(Integer.MAX_VALUE);
		System.err.println(SerialNo.getUNID().length());
		System.err.println(SerialNo.getRomdomID());
		System.err.println(Integer.MAX_VALUE);
		System.err.println(SerialNo.createContractNo("apple"));
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	@SuppressWarnings("static-access")
	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	
}
