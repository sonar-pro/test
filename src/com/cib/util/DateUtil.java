package com.cib.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateUtil {

	/** ���ڸ�ʽ��--��������ʱ��** */
	private static HashMap<String, SimpleDateFormat> dateFormatMap = new HashMap<String, SimpleDateFormat>();

	private static Calendar calendar = Calendar.getInstance();

	public static final String YEAR = "YYYY";
	public static final String MM = "MM";
	public static final String DD = "DD";
	public static final String HH = "HH";
	public static final String MI = "MI";
	public static final String SS = "SS";
	
	public static final int HOUR  = Calendar.HOUR ;
	public static final int MINUTE   = Calendar.MINUTE  ;
	public static final int MONTH  = Calendar.MONTH ;
	public static final int SECOND  = Calendar.SECOND ;
	public static final int DAY_OF_MONTH  = Calendar.DAY_OF_MONTH ;
	
	public static final String TIME_TYPE_TIME = "HH:mm:ss";
	public static final String TIME_TYPE_DAY = "yyyy-MM-dd";
	public static final String TIME_TYPE_SIMPLE = "yyyy-MM-dd HH:mm:ss";

	public static Date DEFAULT_DATE = new Date(0);

	static {
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
	}

	public static String getDateFormatByDateStr(String dateStr) {
		String forMatStr = "yyyy-MM-dd HH:mm:ss";

		if (dateStr.indexOf(".") != -1) {
			forMatStr = forMatStr.replaceAll("-", ".");
		} else if (dateStr.indexOf("/") != -1) {
			forMatStr = forMatStr.replaceAll("-", "/");
		} else if (dateStr.indexOf("-") == -1) {
			forMatStr = forMatStr.replaceAll("-", "");
		}

		forMatStr = forMatStr.substring(0, dateStr.length());

		return forMatStr;
	}

	/**
	 * @��������:
	 * @param userFormat
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static SimpleDateFormat getUserFormat(String userFormat) throws Exception {
		if (null == userFormat || userFormat.equals("")) {
			userFormat = TIME_TYPE_SIMPLE;
		}
		try {
			synchronized (dateFormatMap) {
				if (!dateFormatMap.containsKey(userFormat)) {
					SimpleDateFormat simpleFormat = new SimpleDateFormat(userFormat);
					dateFormatMap.put(userFormat, simpleFormat);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return (SimpleDateFormat) dateFormatMap.get(userFormat).clone();
	}

	/**
	 * @��������:������ת��Ϊ�ַ���
	 * @param date
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static String parseDateToString(Date date, String formatStirng) throws Exception {
		if (date == null) {
			return "";
		}
		return getUserFormat(formatStirng).format(date);
	}

	/**
	 * @��������:���ַ����D�Q������
	 * @param dateStr
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static Date parseStringToDate(String dateStr, String formatStirng) {
		try {
			return getUserFormat(formatStirng).parse(dateStr);
		} catch (Exception ex) {
			return DEFAULT_DATE;
		}
	}

	/**
	 * @��������:���ַ����D�Q������
	 * @param dateStr
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static Date parseStringToDate(String dateStr) {
		if (CommonMethod.isNull(dateStr) || dateStr.length() < 4) {
			return DEFAULT_DATE;
		}
		String dateFormat = null;
		SimpleDateFormat sd = null;
		try {
			dateFormat = getDateFormatByDateStr(dateStr);
			sd = getUserFormat(dateFormat);
			return sd.parse(dateStr);
		} catch (Exception ex) {
			return DEFAULT_DATE;
		}
	}

	/**
	 * @��������:��ȡ��ǰʱ��
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static Date getCurrentDate() throws Exception {
		Date currTime = new Date(System.currentTimeMillis());
		return currTime;
	}

	/**
	 * @��������:��������
	 * @param field
	 * @param value
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static Date addDate(Date d,int field,int value)
	{
		Calendar cal = ((Calendar) calendar.clone());
		cal.setTime(d);
		cal.add(field, value);
		return cal.getTime();
	}
	/**
	 * @��������:���ִ������
	 * @param curr
	 *            ��ǰ
	 * @param execute
	 *            ִ��ʱ��
	 * @param delay
	 *            �ӳ�ʱ��
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean detecteTimeValidate(Date currTime, Date standTime, long delay) {
		long compareM = currTime.getTime();
		long refM = standTime.getTime();
		return compareM > (refM - delay) && compareM < (refM + delay);
	}

	/**
	 * @��������:���ָ��ʱ���Ƿ��� ָ����ʱ��������
	 * @param compareTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean detecteTimeInRange(Date currTime, Date beginTime, Date endTime) {
		long currM = currTime.getTime();
		long beginM = beginTime.getTime();
		long endM = endTime.getTime();
		return currM > beginM && currM < endM;
	}

	/**
	 * @��������:�жϵ�ǰʱ���Ƿ���ָ��ʱ�� ��ָ�������ѵ��
	 * @param compareTime
	 * @param beginTime
	 * @param intervalNum
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean detecteTimeIntervalUnit(Date currTime, Date beginTime, int intervalNum) {
		Calendar cal = ((Calendar) calendar.clone());
		cal.setTime(currTime);
		int cDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		cal.setTime(beginTime);
		int bDayOfYear = cal.get(Calendar.DAY_OF_YEAR);

		if (((cDayOfYear - bDayOfYear) % intervalNum) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @��������:�жϵ�ǰʱ���Ƿ���ָ��ʱ�� ��ָ�������ѵ��
	 * @param compareTime
	 * @param beginTime
	 * @param intervalNum
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean detecteWeekIntervalUnit(Date beginDate, Date endDate, int weekDay, int intervalNum) {
		Calendar cal = ((Calendar) calendar.clone());
		cal.setTime(endDate);
		int eDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		if (weekDay != eDayOfWeek) {
			return false;
		}

		int times = getTimesOfWeekDay(beginDate, endDate, weekDay);
		if (times % intervalNum == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @��������:�жϴ�ָ��ʱ�俪ʼ�������ٸ�ָ�����ܼ��� Ӌ��ָ���r�g�ΰ������ق�ָ��������--�������£����㿪ʼ����Ϊһ���еĵڼ������ڣ�����ʱ��Ϊһ���еĵڼ������ڣ���ֵ +
	 *                            1 - ��ʼʱ���Ƿ��Ѿ���ָ������ -����ʱ���Ƿ�û��ָ������
	 * @param compareTime
	 * @param beginTime
	 * @param intervalNum
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static int getTimesOfWeekDay(Date beginDate, Date endDate, int weekDay) {
		Calendar cal = ((Calendar) calendar.clone());
		cal.setTime(beginDate);

		int bWeekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
		int bDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		cal.setTime(endDate);

		int eWweekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
		int eDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		return (eWweekOfYear - bWeekOfYear) + 1 - (bDayOfWeek > weekDay ? 1 : 0) - (eDayOfWeek < weekDay ? 1 : 0);
	}

	/**
	 * @��������:�жϴ�ָ��ʱ�俪ʼ�������ٸ�ָ�����ܼ��� Ӌ��ָ���r�g�ΰ������ق�ָ��������--�������£����㿪ʼ����Ϊһ���еĵڼ������ڣ�����ʱ��Ϊһ���еĵڼ������ڣ���ֵ +
	 *                            1 - ��ʼʱ���Ƿ��Ѿ���ָ������ -����ʱ���Ƿ�û��ָ������
	 * @param compareTime
	 * @param beginTime
	 * @param intervalNum
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static int getTimesOfMonthDay(Date beginDate, Date endDate, int monthDay) {
		Calendar cal = ((Calendar) calendar.clone());
		cal.setTime(beginDate);

		int bMonthOfYear = cal.get(Calendar.MONTH);
		int bDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(endDate);

		int eMonthOfYear = cal.get(Calendar.MONTH);
		int eDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

		return (eMonthOfYear - bMonthOfYear) + 1 - (bDayOfMonth > monthDay ? 1 : 0) - (eDayOfMonth < monthDay ? 1 : 0);
	}

	/**
	 * @��������:�жϵ�ǰʱ���Ƿ���ָ��ʱ�� ��ָ�������ѵ��
	 * @param compareTime
	 * @param beginTime
	 * @param intervalNum
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean detecteMonthDayIntervalUnit(Date beginDate, Date endDate, int monthDay, int intervalNum) {
		Calendar cal = ((Calendar) calendar.clone());
		cal.setTime(endDate);
		int eDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

		if (monthDay != eDayOfMonth) {
			return false;
		}

		int times = getTimesOfMonthDay(beginDate, endDate, monthDay);
		if (times % intervalNum == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @��������:
	 * @param beginDate
	 * @param endDate
	 * @param daySeq
	 * @param weekDay
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static int getTimesOfWeekMonth(Date beginDate, Date endDate, int weekSeq, int weekDay) {
		Calendar cal = ((Calendar) calendar.clone());
		cal.setTime(beginDate);
		int fromMonth = cal.get(Calendar.MONTH);
		int from_week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
		int from_day_of_week = cal.get(Calendar.DAY_OF_WEEK);
		cal.setTime(endDate);

		int currMonth = cal.get(Calendar.MONTH);
		int curr_week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
		int curr_day_of_week = cal.get(Calendar.DAY_OF_WEEK);

		return (currMonth - fromMonth) + 1 - ((from_week_of_month > weekSeq || (from_week_of_month == weekSeq && from_day_of_week > weekDay)) ? 1 : 0)
				- ((curr_week_of_month < weekSeq || (curr_week_of_month == weekSeq && curr_day_of_week < weekDay)) ? 1 : 0);
	}

	/**
	 * @��������:�жϵ�ǰʱ���Ƿ���ָ��ʱ�� ��ָ�������ѵ��
	 * @param compareTime
	 * @param beginTime
	 * @param intervalNum
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean detecteMonthWeekDayIntervalUnit(Date beginDate, Date endDate, int weekSeq, int weekDay, int intervalNum) {
		Calendar cal = ((Calendar) calendar.clone());
		cal.setTime(endDate);
		int eWeekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);
		int eDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		if (weekSeq != eWeekOfMonth || weekDay != eDayOfWeek) {
			return false;
		}

		int times = getTimesOfWeekMonth(beginDate, endDate, weekSeq, weekDay);
		if (times % intervalNum == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @��������:�жϵ�ǰʱ���Ƿ���ָ��ʱ�� ��ָ�������ѵ��
	 * @param compareTime
	 * @param beginTime
	 * @param intervalNum
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean detecteHourIntervalUnit(Date standardTime, Date currTime, int intervalNum, long delayTime) {
		long sH = standardTime.getTime();
		long cH = currTime.getTime();

		int difH = Math.round((cH - sH) / (60 * 60 * 1000) - 0.5f);
		if (difH % intervalNum != 0) {
			return false;
		}

		long sdH = sH + difH * (60 * 60 * 1000);
		if (cH > sdH - delayTime && cH < sdH + delayTime) {
			return true;
		}
		return false;
	}

	/**
	 * @��������:�жϵ�ǰʱ���Ƿ���ָ��ʱ�� ��ָ�������ѵ��
	 * @param compareTime
	 * @param beginTime
	 * @param intervalNum
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean detecteMinuteIntervalUnit(Date standardTime, Date currTime, int intervalNum, long delayTime) {
		long sM = standardTime.getTime();
		long cM = currTime.getTime();

		int difM = Math.round((cM - sM) / (60 * 1000) - 0.5f);
		if (difM % intervalNum != 0) {
			return false;
		}

		long sdM = sM + difM * 86400;
		if (cM > sdM - delayTime && cM < sdM + delayTime) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {

		try {
			// DateUtil.getUserFormat("yyyyMMdd").toPattern();
			// System.out.println(DateUtil.getUserFormat("yyyy-MM-dd").toPattern());
			// date0 =
			// DateUtil.parseStringToDate(jobData.get(emt.getAttribute("dateField")),
			// "yyyyMMdd");
			System.out.println(DateUtil.parseStringToDate("2006/10/21 10:10:10"));
			// Date appDate = DateUtil.parseStringToDate("20080325",
			// "yyyyMMdd");
			// System.out.println(appDate.getTime());
			// Date birthDate = DateUtil.parseStringToDate("19811028",
			// "yyyyMMdd");
			//			
			// System.out.println(Math.floor((appDate.getTime() -
			// birthDate.getTime()) / (24 * 3600 * 1000 * 365L)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
