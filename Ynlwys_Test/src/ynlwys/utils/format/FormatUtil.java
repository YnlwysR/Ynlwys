package ynlwys.utils.format;

/**
 * 创建时间: 2015年9月11日14:50:48.
 * 
 * 功能: 提供格式化类的工具类.
 * 
 * 介绍:
 * 		0,该工具类中包含了常规的和非常规的格式化方法.
 * 		1,当中包含的全部都是静态方法,直接通过类名调用即可.
 * 
 * @author LiYinghao
 *
 */

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FormatUtil {
	
	/**
	 * 将一个Long类型的时间值变成 'yyyy-MM-dd' 格式类型的时间值 年月日格式化.
	 * @param time Long类型(毫秒)的时间值.
	 * @return String类型的 'yyyy-MM-dd' 格式的时间值.
	 */
	public static final String formatDate(Long time){
		if(time == null)
			return null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date(time));
	}
	
	/**
	 * 将一个Long类型的时间值变成 'HH:mm:ss' 格式类型的时间值 时分秒格式化.
	 * @param time Long类型(毫秒)的时间值.
	 * @return String类型的 'HH:mm:ss' 格式的时间值.
	 */
	public static final String formatTime(Long time){
		if(time == null)
			return null;
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(new Date(time));
	}
	
	/**
	 * 将一个Long类型的时间值变成 'yyyy-MM-dd HH:mm:ss' 格式类型的时间值 年月日,时分秒格式化.
	 * @param time Long类型(毫秒)的时间值.
	 * @return String类型的 'yyyy-MM-dd HH:mm:ss' 格式的时间值.
	 */
	public static final String formatDateTime(Long time){
		if(time == null)
			return null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date(time));
	}
	
	/**
	 * 将字符串的日期类型转换为毫秒值的时间值.
	 * @param date String 类型的日期值 格式为'yyyy-MM-dd' 
	 * @return Long 类型的日期值.
	 * @throws ParseException
	 */
	public static long getLongDateByStringDate(String date) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateTemp = null;
		try {
			dateTemp = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}        
		return dateTemp.getTime();
	}
	
	/**
	 * 金钱格式化,格式化Double类型的数据为保留小数后两位.
	 * @param money 需要格式化的值.
	 * @return String 类型的保留两位小数的值.
	 */
	public static final String formatMoney(Double money) {
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(money);
	}
}
