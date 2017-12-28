package com.personalWebsite.utils;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * 序列化工具类
 * Created by xiatianlong on 2017/12/28.
 */
public class SerializeUtil {

	/**
	 * 序列化
	 * @param t 序列化对象
	 * @param <T> t
	 * @return 序列化结果
	 * @throws IOException exception
	 */
	public static <T> String serialize(T t) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(t);
	}

	/**
	 * 反序列化
	 * @param json json
	 * @param cls class对象
	 * @param <T>  t
	 * @return	反序列化结果
	 * @throws IOException exception
	 */
	public static <T> T deserialize(String json, Class<T> cls) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.readValue(json, cls);
	}

}
