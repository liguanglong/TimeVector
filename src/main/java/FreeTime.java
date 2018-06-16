import com.sun.org.glassfish.external.statistics.Statistic;

import java.util.*;

/**
 * @author LiGuanglong
 * @date 2018/5/13
 */
public class FreeTime {
    private List<TimeFeature> timeFeatureList = new ArrayList<TimeFeature>();


    /**
     * 根据给定的持续时间，开始结束时间获取所有Schedule
     *
     * @param startTime
     * @param endTime
     * @param startWeek
     * @param endWeek
     * @param duration
     * @return
     */
    public Map<Integer, List<Schedule>> getAllTime(Calendar startTime, Calendar endTime, int startWeek, int endWeek, Integer duration) {

        Map<Integer, List<Schedule>> schedules = new HashMap<Integer, List<Schedule>>(16);

        Calendar temp;
        for (int i = startWeek; i <= endWeek; i++) {
            Calendar init = (Calendar) startTime.clone();
            Calendar endInit = (Calendar) init.clone();
            endInit.add(Calendar.DAY_OF_MONTH, 1);
            List<Schedule> scheduleList = new ArrayList<Schedule>();
            while (startTime.before(endInit)) {
                temp = (Calendar) startTime.clone();
//                System.out.println("beforeCalc:"+startTime.getTime());
                startTime.add(Calendar.MINUTE, duration);
//                System.out.println("afterCalc:"+startTime.getTime());
                if (startTime.getTimeInMillis()<=endTime.getTimeInMillis()) {
                    Calendar st = (Calendar) temp.clone();
                    Calendar e = (Calendar) startTime.clone();
                    Schedule s = new Schedule(st, e);
                    scheduleList.add(s);
                }
            }
            schedules.put(i, scheduleList);
            startTime = (Calendar) init.clone();
            startTime.add(Calendar.DAY_OF_MONTH, 1);
//            endTime.add(Calendar.DAY_OF_MONTH,1);

//            System.out.println("startTime:" + startTime.getTime());
//            System.out.println("endTime:" + endTime.getTime());
        }

        return schedules;
    }


    /**
     * 判断空闲时间和非空闲时间是否冲突
     *
     * @param freeTime
     * @param notFreeTime
     * @return
     */
    public boolean judge(Schedule freeTime, Schedule notFreeTime) {
        boolean res = false;
        System.out.println("freeTime:" + freeTime.getStartTime().getTime());
        System.out.println("notFreeTime:" + notFreeTime.getStartTime().getTime());
        boolean temp = (freeTime.getStartTime().before(notFreeTime.getStartTime()) && freeTime.getEndTime().after(notFreeTime.getStartTime())) ||
                (freeTime.getStartTime().before(notFreeTime.getEndTime()) && freeTime.getEndTime().after(notFreeTime.getEndTime()));
        if (temp) {
            res = true;
        }
        return res;
    }


    /**
     * 判断两个日程是否重叠
     * @param schedule1
     * @param schedule2
     * @return
     */
    public boolean judgeTimeOverlap(Schedule schedule1, Schedule schedule2) {
        boolean ret;
        //不重叠
        if (schedule1.getEndTime().before(schedule2.getStartTime()) || schedule2.getEndTime().before(schedule1.getStartTime())) {
            ret = false;
        } else {
            //重叠
            ret = true;
        }
        return ret;
    }


    /**
     *  通过毫秒数比较schedule是否重叠，因为Date.before()不支持等于判断
     * @param schedule1
     * @param schedule2
     * @return
     */
    public boolean judgeTimeOverlapByMills(Schedule schedule1, Schedule schedule2) {
        boolean ret;
        //不重叠
        if (schedule1.getEndTime().getTimeInMillis()<= schedule2.getStartTime().getTimeInMillis() ||
                schedule2.getEndTime().getTimeInMillis()<= schedule1.getStartTime().getTimeInMillis()) {
            ret = false;
        } else {
            //重叠
            ret = true;
//            System.out.println("s1.start:"+schedule1.getStartTime().getTimeInMillis());
//            System.out.println("s1.end:"+schedule1.getEndTime().getTimeInMillis());
//            System.out.println("s2.start:"+schedule2.getStartTime().getTimeInMillis());
//            System.out.println("s2.end:"+schedule2.getEndTime().getTimeInMillis());
//            System.out.println("***");
        }
        return ret;
    }



}
