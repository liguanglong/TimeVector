import java.util.Calendar;
import java.util.Date;

/**
 * @author LiGuanglong
 * @date 2018/5/13
 */
public class TimeUtils {
    public static final long day_ms = 1000 * 3600 * 24;


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


    /**
     * 计算endDate-startDate 相差分钟数
     *
     * @return
     */
    public static long calDistanceInMinutes(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return -1;
        }
        long dif = (endDate.getTime() - startDate.getTime()) / (1000 * 60);
        return Math.abs(dif);
    }


    /**
     * 获取周一日期
     *
     * @return
     */
    private static Calendar getMondayCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        return calendar;

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
     * 获取加上分钟的新日期
     *
     * @param calendar
     * @param minutes
     * @return
     */
    public static Calendar addMinutes(Calendar calendar, int minutes) {
        calendar.add(Calendar.MINUTE, minutes);
        return calendar;
    }

}
