package ynlwys.utils.format;

/**
 * ����ʱ��: 2015��9��11��14:41:11.
 * 
 * ����: ���ڽ��и�ʽ���Ĺ�����.
 * 
 * ����:
 * 		0,���а����˳���ĸ�ʽ������,�ͷǳ���ĸ�ʽ������.
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
	 * ���ַ�������ת����,����ֵҲ����long����ֵ.
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
	 * �ж���������ǲ�����һ���� - ���ϵͳʱ��õ�����0.
	 */
	public static Boolean isAlike(String leaveDate) {
		Calendar calendar = Calendar.getInstance();
		
		String month = leaveDate.split("-")[1];
		String year = leaveDate.split("-")[0];
		String monthTemp = calendar.get(Calendar.MONTH) < 10 ? "0"+(calendar.get(Calendar.MONTH)) : (calendar.get(Calendar.MONTH)) + "";
		String yearTemp = calendar.get(Calendar.YEAR) + "";
		
		/**#���ȡ��������00��ô����Ϊ��12 - 1#*/
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

