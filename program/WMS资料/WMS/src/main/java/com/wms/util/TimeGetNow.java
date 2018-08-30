package com.wms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGetNow {

	public static String getTime() {

		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(day);
		//System.out.println(time);
		return time;
	}

}
