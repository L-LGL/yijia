package com.zt.util;

import java.text.*;
import java.util.Date;

public class TimeUtil {

	public static String getNow(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String str = format.format(date);
		return str;
	}


}
