package com.cloud.vblog.common.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @Author：chenaiwei
 * @Description：UUIDUtils 这里不使用开源的uuid生成器
 * @CreateDate：2020/7/6 15:52
 */
public class UUIDUtils {
	private UUIDUtils(){}

	/**
	 * 生成单实列下的唯一uuid
	 * @return
	 */
	public static String genUid(){
		synchronized (UUIDUtils.class){
			String timeMillis = String.valueOf(System.currentTimeMillis());
			String pre = timeMillis.substring(0, 5);
			String end = timeMillis.substring(timeMillis.length() - 4, timeMillis.length()-1);
			return pre+ UUID.randomUUID().toString().replace("-","").substring(0,8)+end;
		}
	}
}
