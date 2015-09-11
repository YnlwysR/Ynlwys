package ynlwys.utils.format;

/**
 * 创建时间: 2015年9月11日14:50:48.
 * 
 * 功能: 提供格式化类的工具类.
 * 
 * 介绍:
 * 		0,该工具类中包含了常规的和非常规的格式化方法.
 * 
 * 
 * @author LiYinghao
 *
 */
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 格式化工具类 - 当中可以对多种数据进行格式化.
 * 
 * 时间:2015年6月2日09:42:26.
 * 	
 * 		更新:
 * 			0,判断传递的日期是不是上一个月.
 * 
 * @author LiYinghao
 *
 */
public class FormatUtil {
	public static final String formatDate(Long time){
		if(time == null)
			return null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date(time));
	}
	public static final String formatTime(Long time){
		if(time == null)
			return null;
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(new Date(time));
	}
	public static final String formatDateTime(Long time){
		if(time == null)
			return null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date(time));
	}
	public static final String formatMoney(Double money) {
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(money);
	}
	/*
	 * 将字符串日期转换成,毫秒值也就是long型数值.
	 * **/
	public static long getdaytime(String date) throws ParseException {
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
	 * 判断请假日期是不是上一个月 - 如果系统时间得到的是0.
	 */
	public static Boolean isAlike(String leaveDate) {
		Calendar calendar = Calendar.getInstance();
		
		String month = leaveDate.split("-")[1];
		String year = leaveDate.split("-")[0];
		String monthTemp = calendar.get(Calendar.MONTH) < 10 ? "0"+(calendar.get(Calendar.MONTH)) : (calendar.get(Calendar.MONTH)) + "";
		String yearTemp = calendar.get(Calendar.YEAR) + "";
		
		/**#如果取出来的是00那么就认为是12 - 1#*/
		if(monthTemp.equals("00")) {
			monthTemp = "12";
		}
		
		if(month.equals(monthTemp) && year.equals(yearTemp)) {
			return true;
		}else {
			return false;
		}
			
	}
	public static String formatDay(double parseDouble) {
		DecimalFormat df = new DecimalFormat("#0.000");
		return df.format(parseDouble);
	}
}
