/**
 * Copyright (c) 2007, 2012, Gordon Hooker. All rights reserved.
 * Utility methods to support TSSFPrayers.
 * 
 */
package com.tssf.ghooker.tssfprayers.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;



/**
 * @author gordonhooker
 *
 */
public class TssfUtils {
	
	// Date _date;
	public TssfUtils()
	{
		
	}

	public static String getDateString(Date date)
	{
		String dateString;
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
		//get current date time with Date()
		// Date date = new Date();
		dateString = dateFormat.format(date);
		return dateString; 
	}


	public static int getDayOfMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}


	public static int getDayOfWeek(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
		// return 10;
	}

	public static int getRandomDayOfMonth() {
		Random rand = new Random();
		int min = 1;
		int max = 30;
		int num = rand.nextInt(max-min+1)+min;
		return num;
	}

	public static int getRandomNumber() {
		Random rand = new Random();
		int min = 1;
		int max = 32768;
		int num = rand.nextInt(max-min+1)+min;
		return num;
	}

}

