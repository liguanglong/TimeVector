/**
 * @author LiGuanglong
 * @date 2018/5/28
 */


import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public class DateUtils {
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYY_MM_DD_HHMMSS = "yyyy-MM-dd hh24:mi:ss";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HHMM = "yyyy-MM-dd HH:mm:ss";
    public static final String ES_Date = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String ES_Date_nozone = "yyyy-MM-dd'T'HH:mm:ss";
    public static final long day_ms = 1000 * 3600 * 24;

    public static final String YYYYMMDD_HHMM = "yyyy-MM-dd HH:mm";



    public static Date parseStr2Date(String format, String dateStr) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(format)) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);

        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parseDate2Str(String format, Date date) {
        if (StringUtils.isEmpty(format) || date == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 获得未来N天的DATE
     *
     * @param calendar
     * @param n
     * @return
     */
    public static Date getAfterNDaysDate(Calendar calendar, int n) {
        if (calendar == null) {
            return null;
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + n);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            return calendar.getTime();
        }
    }

    /**
     * 获得未来N天的DATESTR
     *
     * @param calendar
     * @param n
     * @return yyyyMMdd
     */
    public static String getAfterNDaysDatesTR(Calendar calendar, int n) {
        if (calendar == null) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + n);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            return sdf.format(calendar.getTime());
        }
    }

    /**
     * 获得未来N天的DATESTR
     *
     * @param calendar
     * @param n
     * @return yyyy-MM-dd
     */
    public static String getAfterNDaysDate(Calendar calendar, String format, int n) {
        if (calendar == null) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + n);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            return sdf.format(calendar.getTime());
        }
    }

    /**
     * 获得未来N天的DATESTR
     *
     * @param calendar
     * @param n
     * @return
     */
    public static String getAfterNDaysDatesTRWithFormat(Calendar calendar, int n, String format) {
        if (calendar == null) {
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + n);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            return sdf.format(calendar.getTime());
        }
    }

    /**
     * 获得未来N天的DATE
     *
     * @param date
     * @param n
     * @return
     */
    public static Date getAfterNDaysDate(Date date, int n) {
        if (date == null) {
            return null;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, n);
            return cal.getTime();
        }
    }

    /**
     * 获得日期的天数
     *
     * @param calendar
     * @return
     */
    public static int getDayNum(Calendar calendar) {
        if (calendar == null) {
            return 0;
        } else {
            return calendar.get(Calendar.DAY_OF_MONTH);
        }
    }

    /**
     * 获得月与天数
     *
     * @param calendar
     * @param n
     * @return
     */
    public static String getMDstr(Calendar calendar, int n) {
        if (calendar == null) {
            return null;
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + n);
            SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
            return sdf.format(calendar.getTime());
        }
    }

    public static Date getBeforeDaysDate(Calendar calendar, int n) {
        if (calendar == null) {
            return null;
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - n);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            return calendar.getTime();
        }
    }

    public static Date getAfterNsecondsDate(Date date, Integer n) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + n);
        return calendar.getTime();

    }

    /**
     * 时间撮转日期
     *
     * @param mills
     * @return
     */
    public static Date getDateByMills(Long mills) {
        if (mills == null) {
            return null;
        }
        Date date = new Date();
        date.setTime(mills);
        return date;
    }

    public static String getDateStr(Date date, String format) {
        if (date == null || StringUtils.isEmpty(format)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取N天的DateStr
     *
     * @param date
     * @param format
     * @param n
     * @return yyyyMMdd
     */
    public static String getNDaysDateStr(String date, String format, Integer n) {

        if (date == null || date.length() == 0) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(DateUtils.parseStr2Date(format, date));

        return getAfterNDaysDatesTR(calendar, n);
    }

    public static String getNDaysDateWithFormat(String date, String format, Integer n) {

        if (date == null || date.length() == 0) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(DateUtils.parseStr2Date(format, date));

        return getAfterNDaysDate(calendar, format, n);
    }

    /**
     * 获取N天的DateStr
     *
     * @param date
     * @param format
     * @param n
     * @return
     */
    public static String getNDaysDateStr1(String date, String format, Integer n) {

        if (date == null || date.length() == 0) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(DateUtils.parseStr2Date(format, date));

        return getAfterNDaysDatesTRWithFormat(calendar, n, format);
    }

    /**
     * 判断字符串格式是否正确
     *
     * @param date
     * @param format
     * @return
     */
    public static boolean isValidDateStr(String date, String format) {

        if (date == null || date.length() == 0) {
            return false;
        }

        boolean convertSuccess = true;

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {

            dateFormat.setLenient(false);
            dateFormat.parse(date);
        } catch (ParseException e) {
            convertSuccess = false;
        }

        return convertSuccess;

    }

    /**
     * 判断字符串格式是否是hh:mm格式
     *
     * @param time
     * @return
     */
    public static boolean isValidTimeStr(String time) {

        boolean convertSuccess = false;

        if (!StringUtils.isBlank(time) && time.length() == 5) {

            try {
                String[] str = time.split(":");

                if (str.length == 2) {

                    if (str[0].length() == 2 && Integer.parseInt(str[0]) >= 0 && Integer.parseInt(str[0]) < 24
                            && str[1].length() == 2 && Integer.parseInt(str[1]) >= 0 && Integer.parseInt(str[1]) < 60) {
                        convertSuccess = true;
                    }
                }
            } catch (Exception e) {

            }

        }

        return convertSuccess;

    }

    /**
     * 比较两个时间字符串
     *
     * @param dateStr1
     * @param dateStr2
     * @param format
     * @return
     * @throws ParseException
     */
    public static boolean compare(String dateStr1, String dateStr2, String format) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Date date1 = sdf.parse(dateStr1);
        Date date2 = sdf.parse(dateStr2);

        // Date类的一个方法，如果a早于b返回true，否则返回false
        if (date1.before(date2))
            return true;
        else
            return false;

    }

    /**
     * 为指定的时间增加/减少分钟
     *
     * @param dateStr 指定时间
     * @param mins    分钟数，可以为负数
     * @return
     */
    public static String addDateMinute(String dateStr, int mins) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HHMM);

        String res = null;

        try {
            Date date = sdf.parse(dateStr);

            if (date == null) {
                return res;
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, mins);
            date = calendar.getTime();
            res = sdf.format(date);

        } catch (Exception e) {

        }

        return res;

    }

    /**
     * 为指定的时间增加/减少分钟
     *
     * @param date 指定时间
     * @param mins 分钟数，可以为负数
     * @return
     */
    public static Date addDateMinute(Date date, int mins) {

        try {

            if (date == null) {
                return date;
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, mins);
            date = calendar.getTime();

        } catch (Exception e) {

        }

        return date;

    }

    /**
     * 为指定的时间增加/减少小时
     *
     * @param date  指定时间
     * @param hours 小时,可以为负数
     * @return
     */
    public static Date getNHourAfterDate(Date date, int hours) {

        try {

            if (date == null) {
                return date;
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.HOUR, hours);
            date = calendar.getTime();

        } catch (Exception e) {

        }
        return date;
    }

    /**
     * 日期距离当前时间
     *
     * @param date
     * @return 日期距离当前时间（毫秒）
     */
    public static Long getDateBeforeNow(Date date) {

        Long res = 0L;

        if (Objects.isNull(date)) {
            return res;
        }

        Long dateToLong = date.getTime();

        res = dateToLong - System.currentTimeMillis();

        return res;
    }

    public static Long getTodayStart() {
        Calendar start = Calendar.getInstance();
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        return start.getTime().getTime();
    }

    public static Long getTodayEnd() {
        Calendar end = Calendar.getInstance();
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        end.set(Calendar.MILLISECOND, 999);
        return end.getTime().getTime();

    }

    /**
     * 计算上周一离现在有多少天
     */
    public static int lastMondayDis() {
        Calendar lastMondDay = Calendar.getInstance();
        lastMondDay.setFirstDayOfWeek(Calendar.MONDAY);
        lastMondDay.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        lastMondDay.add(Calendar.DATE, -7);
        // System.out.println(lastMondDay.getTime());

        Calendar today = Calendar.getInstance();
        long lastMondayDis = (today.getTimeInMillis() - lastMondDay.getTimeInMillis()) / (24L * 60 * 60 * 1000);
        return (int) lastMondayDis;

    }

    /**
     * 0 表示本周一的00：00：00时间，n=-1表示上周一，n=1表示下周一
     *
     * @param n
     * @return
     */
    public static Date getMonday(int n) {
        Calendar calendar = getMondayCalendar();

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(Calendar.DAY_OF_YEAR, n * 7);
        return calendar.getTime();

    }

    /**
     * 0 表示本周天：23：59:59，n=-1表示上周天，n=1表示下一周
     *
     * @param n
     * @return
     */
    public static Date getSunday(int n) {
        Calendar calendar = getMondayCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(Calendar.DAY_OF_YEAR, n * 7);
        return calendar.getTime();
    }

    /**
     * 计算endDate-startDate 相差天数
     *
     * @return
     */
    public static long calDistanceInDays(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return -1;
        }
        long dif = (endDate.getTime() - startDate.getTime()) / day_ms;

        return Math.abs(dif);
    }

    private static Calendar getMondayCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar;

    }

    public static String getTodayDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date today = new Date();
        return sdf.format(today);
    }


    /**
     * 获取当前时间上个月的月份
     *
     * @param format
     * @return
     */
    public static String getLastMonth(String format) {
        Date date = new Date();
        return getLastMonth(format, date);
    }

    /**
     * 获取指定日期的是一个月份
     *
     * @param format
     * @param date
     * @return
     */
    public static String getLastMonth(String format, Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(c.getTime());
    }

    /**
     * 获取每个月工作日的天数，只去除了周六、周日，没有去除法定假日
     *
     * @param year
     * @param month
     * @return
     */
    public static int getWorkDateNum(int year, int month) {
        return getRemainWorkDateNum(year, month, 1);
    }

    /**
     * 获取从当前日期开始本月剩余的工作日天数
     *
     * @return
     */
    public static int getRemainWorkDateNum(int year, int month, int day) {
        int nums = 0;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, day);
        while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) < month) {
            int tmpDay = cal.get(Calendar.DAY_OF_WEEK);

            if (!(tmpDay == Calendar.SUNDAY || tmpDay == Calendar.SATURDAY)) {
                nums++;
            }
            cal.add(Calendar.DATE, 1);
        }
        return nums;

    }

    /**
     * 获取n天之后的时间戳
     *
     * @param date
     * @param format
     * @param n
     * @return
     */
    public static long getUninxOfAfterNDay(Date date, String format, int n) {
        Long res = 0L;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String dateAfterNDay = getAfterNDaysDate(calendar, format, n);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            Date date2 = simpleDateFormat.parse(dateAfterNDay);
            calendar.setTime(date2);
            return calendar.getTimeInMillis() / 1000;
        } catch (Exception e) {
            return res;
        }
    }
    /**
     * 获取从给定日期date之后n天的的日期
     * @param date
     * @param n
     * @return
     */
    public static Long getNDaysAfterDates(Long date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        calendar.add(Calendar.DATE, n);
        return calendar.getTimeInMillis();
    }

    public static void main(String args[]) throws ParseException {
        /*
         * Date date1 = new Date(); Date date = getDateByMills(date1.getTime());
         * System.out.println(date);
         * System.out.println(isValidDateStr("20150501", "yyyyMMdd"));
         *
         * System.out.println(isValidTimeStr("1:000"));
         *
         * System.out.println(isWorkingTime("ALLOC_weekday", "ALLOC_weekend",
         * "09:00", "11:00"));
         */

        // System.out.println(addDateMinute("2017-03-25 12:00", -30));

//        Date start = parseStr2Date(YYYY_MM_DD, "2017-09-01");
//        Date end = parseStr2Date(YYYY_MM_DD, "2017-09-07");
//        int i = 8;
//        System.out.println(calDistanceInDays(start, end) > i);
//
//        String tmp = "2017-04-06 11:48:00";

        // System.out.println(tmp.substring(0,tmp.lastIndexOf(":")+1) +
        // RandomUtils.random(10, 59));

        // System.out.println(getDateBeforeNow(date));

        // System.out.println(getDateBeforeNow(date));

    }

}
