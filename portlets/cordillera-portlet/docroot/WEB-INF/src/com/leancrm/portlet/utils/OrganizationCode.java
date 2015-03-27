package com.leancrm.portlet.utils;

import java.util.HashMap;
import java.util.Map;

public class OrganizationCode {

	private static Map<Integer, String> encodeMap;
	private static Map<String, Integer> decodeMap;
	
	private static final int[] PIVOT = {1,2,3,4};
	private static final int SIZE_PIVOT = 3;
	
	static {
		encodeMap = new HashMap<Integer, String>();
		encodeMap.put(0, "I");
		encodeMap.put(1, "D");
		encodeMap.put(2, "T");
		encodeMap.put(3, "B");
		encodeMap.put(4, "E");
		encodeMap.put(5, "Z");
		encodeMap.put(6, "C");
		encodeMap.put(7, "G");
		encodeMap.put(8, "S");
		encodeMap.put(9, "N");
		encodeMap.put(10, "7");
		encodeMap.put(11, "X");
		encodeMap.put(12, "1");
		encodeMap.put(13, "3");
		encodeMap.put(14, "5");
		encodeMap.put(15, "W");
		encodeMap.put(16, "V");
		encodeMap.put(17, "6");
		encodeMap.put(18, "0");
		encodeMap.put(19, "Q");
		encodeMap.put(20, "P");
		encodeMap.put(21, "M");
		encodeMap.put(22, "8");
		encodeMap.put(23, "9");
		encodeMap.put(24, "U");
		encodeMap.put(25, "2");
		encodeMap.put(26, "F");
		encodeMap.put(27, "O");
		encodeMap.put(28, "Y");
		encodeMap.put(29, "6");
		encodeMap.put(30, "R");
		encodeMap.put(31, "J");
		encodeMap.put(32, "4");
		encodeMap.put(33, "A");
		encodeMap.put(34, "H");
		encodeMap.put(35, "L");
		encodeMap.put(36, "K");
		encodeMap.put(37, "$");
		encodeMap.put(38, "%");
		encodeMap.put(39, "&");
		
		buildDecodeMap();
	}
	
	private static String getRandomNumber(int size) {
		StringBuilder result = new StringBuilder();
		
		for (int i=0; i<size; i++) {
			result.append( (int) Math.floor(Math.random()*(0-9)+9) );
		}
		
		return result.toString();
	}
	
	public static String encode(Long value) {
		if (value == null || value <= 0) {
			return null;
		}
		
		StringBuilder codeBuilder = new StringBuilder();
		
		String strVal = String.valueOf(value);
		String restVal = getRandomNumber(10 - strVal.length());
		
		codeBuilder.append(encodeMap.get(strVal.length() * SIZE_PIVOT));
		for (int i=0; i<strVal.length(); i++) {
			codeBuilder.append(encodeMap.get( Integer.parseInt(strVal.substring(i, i+1)) * PIVOT[i % PIVOT.length]));
		}
		for (int i=0; i<restVal.length(); i++) {
			codeBuilder.append(encodeMap.get( Integer.parseInt(restVal.substring(i, i+1)) * PIVOT[i % PIVOT.length]));
		}
		
		return codeBuilder.toString();
	}
	
	public static Long decode(String value) {
		if (value == null || value.isEmpty()) {
			return -1L;
		}
		
		if (decodeMap.get(value.substring(0, 1)) == null) {
			return -1L;
		}
		int length = decodeMap.get(value.substring(0, 1)) / SIZE_PIVOT;
		if (length < 0 || length > value.length()) {
			return -1L;
		}
		StringBuilder strVal = new StringBuilder();
		for (int i=0; i<length; i++) {
			Integer v = decodeMap.get(value.substring(i+1, i+2));
			if (v == null) {
				return -1L;
			}
			strVal.append(v / PIVOT[i % PIVOT.length]);
		}
		
		return Long.valueOf(strVal.toString());
	}
	
	private static void buildDecodeMap() {
		decodeMap = new HashMap<String, Integer>();
		for (Integer encodeKey : encodeMap.keySet()) {
			decodeMap.put(encodeMap.get(encodeKey), encodeKey);
		}
	}
	
	public static void main(String[] args) {
		Long l = 71810L;
		String e = encode(l);
		System.out.println("Encode Value: " + e);
		Long d = decode(e);
		System.out.println("Decode Value: " + d);
	}
	
}
