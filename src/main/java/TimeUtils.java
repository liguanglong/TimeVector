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
        long dif = (endDate.getTime() - startDate.getTime()) / (1000*60);
        return Math.abs(dif);
    }





    /**
     * 获取加上分钟的新日期
     * @param calendar
     * @param minutes
     * @return
     */
    public static Calendar addMinutes(Calendar calendar,int minutes){

        calendar.add(Calendar.MINUTE,minutes);
        return  calendar;

    }

}
