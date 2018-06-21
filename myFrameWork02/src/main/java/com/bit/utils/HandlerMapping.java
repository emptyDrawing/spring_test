package com.bit.utils;

import java.util.HashMap;

public class HandlerMapping {

	private static HashMap<String, BitController> map = new HashMap<String, BitController>();

	public static void setMap(String url,String value){
		
		try {
			Class<?> clzz = Class.forName(value);
			BitController controller = (BitController) clzz.newInstance();
			map.put(url, controller);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static BitController getMap(String uri) {
		return map.get(uri);
	}
}
