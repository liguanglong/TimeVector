import java.util.*;

/**
 * @author LiGuanglong
 * @date 2018/5/13
 */
public class FreeTime {
    private List<TimeFeature> timeFeatureList = new ArrayList<TimeFeature>();


    public Map<Integer, List<Schedule>> getAllTime(Calendar startTime, Calendar endTime, int startWeek, int endWeek, Integer duration) {

        Map<Integer, List<Schedule>> schedules = new HashMap<Integer, List<Schedule>>(16);
        Integer week = startTime.get(Calendar.DAY_OF_WEEK);

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


}
