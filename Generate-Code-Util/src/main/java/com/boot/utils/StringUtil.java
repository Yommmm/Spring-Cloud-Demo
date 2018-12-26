package com.boot.utils;

public class StringUtil {

	public static final char UNDERLINE = '_';

	/**
	 * 下划线格式字符串转换为驼峰格式字符串
	 * 
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param) {
		param = param.toLowerCase();
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == UNDERLINE) {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 驼峰格式字符串转换为下划线格式字符串
	 * 
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 首字母大写
	 * @param param
	 * @return
	 */
	public static String firstCharToUpCase(String param) {
		if(null == param || param.length() <= 1) {
			return param;
		} else {
			param = param.substring(0, 1).toUpperCase() + param.substring(1, param.length());
			return param;
		}
	}
	
	/**
	 * 去除前缀
	 * @param source
	 * @param prefix
	 * @return
	 */
	public static String removePrefix(String source, String prefix) {
		
		String target = source.replace(prefix, "");
		
		return target;
	}
	
}
