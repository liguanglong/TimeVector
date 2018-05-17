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
                if (startTime.before(endTime)) {
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

            System.out.println("reset" + startTime.getTime());
            System.out.println("rsset" + endTime.getTime());
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


}
