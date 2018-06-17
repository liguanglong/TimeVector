import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;
import jdk.net.SocketFlow;
import org.apache.commons.lang3.ArrayUtils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.*;

/**
 * @author LiGuanglong
 * @date 2018/5/5
 */
public class Main {

    private static final DateTime DATE_TIME = new DateTime();

    //持续时间
    private static final Integer DURATION = 60;


    public static void main(String[] args) {
        /**
         * TimeFeature格式:(时间，持续时间，星期几)
         */

        testCalcSimTop();
    }

    public static void test() {
        //        String s1 = "1:40,30,3";
//        double[] v1 = vector(s1);

//        String s2 = "1:50,30,3";
//        double[] v2 = vector(s2);


//        Calendar startCal = Calendar.getInstance();
//        startCal.set(2018,Calendar.MAY,13,8,30);
//        Calendar endCal = Calendar.getInstance();
//        endCal.set(2018,Calendar.MAY,13,10,0);
//
//        Schedule schedule = new Schedule(startCal,endCal);
//
//        TimeFeature timeFeature  = new TimeFeature(schedule.getStartTime(),
//                (int)TimeUtils.calDistanceInMinutes(schedule.getStartTime().getTime(),schedule.getEndTime().getTime()),
//                schedule.getEndTime().get(Calendar.WEEK_OF_MONTH));
//
//        double[] v1 = vector(timeFeature);
//
//        System.out.println(parserVectorToFeature(v1));

//        testFreeTime();

//        testAllFreeTime();

//        genUserPreferences();


//        Date d = new Date(1512123131321L);
//        System.out.println(getFromat(d));


//        Date now = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String s = simpleDateFormat.format(now);
//        System.out.println(s);
//        if (isValidDateStr(s, "yyyy-MM-dd")) {
//            System.out.println(true);
//        }

//        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

//        Date d = new Date(1512123131321L);

//        DateTime dateTime = DateTime.parse("2012-12-21 23:22:45", format);
//        DateTime dateTime = new DateTime(d);
//        System.out.println(dateTime);

        //时间格式化，输出==> 2012/12/21 23:22:45 Fri
//        String string_u = dateTime.toString("yyyy/MM/dd HH:mm:ss");
//        System.out.println(new DateTime(1512123131321L).toString("yyyy/MM/dd HH:mm:ss"));
//        System.out.println(DATE_TIME.withMillis(1512123151321L).toString("yyyy/MM/dd HH:mm:ss"));
//        System.out.println(DATE_TIME.withMillis(1512133131321L).toString("yyyy/MM/dd HH:mm:ss"));

//        System.out.println(string_u);


//        String timeFrom = "2018-05-01";
//        String timeTo = "2018-05-20";
//        String timeTo = null;
//
//        Date timeFromDate;
//        Date timeToDate;
//        if (timeFrom != null) {
//            timeFromDate = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD, timeFrom);
//        } else {
//            timeFromDate = new Date();
//        }
//
//        if (timeTo != null) {
//            timeToDate = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD, timeTo);
//        } else {
//            timeToDate = new Date();
//        }
//
//        System.out.println(timeFromDate);
//
//        System.out.println(timeToDate);


//        String time = "2018-05-23+16:15:21";
//        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd+HH:mm:ss");
//        long timeL = DateTime.parse(time, format).getMillis();
//        System.out.println(timeL);

        String startTime = "2018-05-23+16:05:05";
        String endTime = "2018-05-24+16:05:12";
        long startTimeL = 0;

        long endTimeL = 0;
//        if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
//            if(DateUtils.isValidDateStr(startTime,DateUtils.YYYY_MM_DD) &&
//                    DateUtils.isValidDateStr(endTime,DateUtils.YYYY_MM_DD)){
//                startTimeL = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD, startTime).getTime();
//                endTimeL = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD, endTime).getTime();
//            } else if(DateUtils.isValidDateStr(startTime,DateUtils.YYYY_MM_DD_HH_MM_SS) &&
//                    DateUtils.isValidDateStr(endTime,DateUtils.YYYY_MM_DD_HH_MM_SS)){
//                startTimeL = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD_HH_MM_SS, startTime).getTime();
//                endTimeL = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD_HH_MM_SS, endTime).getTime();
//            }
//                try {
//            if (startTimeL > endTimeL) {
//                System.out.println("wrong");
//            }
//                }catch (Exception e){
//                    System.out.println("exception");
//                }
//        }
//
//        System.out.println(startTimeL);
//        System.out.println(endTimeL);


//        if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
//            if (DateUtils.isValidDateStr(startTime, DateUtils.YYYY_MM_DD) &&
//                    DateUtils.isValidDateStr(endTime, DateUtils.YYYY_MM_DD)) {
//                startTimeL = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD, startTime).getTime();
//                endTimeL = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD, endTime).getTime();
//            } else if (startTime.contains("+") && endTime.contains("+")) {
//                //由于前端不能传空格，传进来的空格为+，后台需处理下
//                String startTimeF = startTime.split("\\+")[0];
//                String startTimeB = startTime.split("\\+")[1];
//
//                startTime = startTimeF + " " + startTimeB;
//
//                String endTimeF = endTime.split("\\+")[0];
//                String endTimeB = endTime.split("\\+")[1];
//
//                endTime = endTimeF + " " + endTimeB;
//
//                startTimeL = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD_HH_MM_SS, startTime).getTime();
//                endTimeL = DateUtils.parseStr2Date(DateUtils.YYYY_MM_DD_HH_MM_SS, endTime).getTime();
//            }
//
//
//            System.out.println(startTime);
//        }


        String timeFrom = "20180506 0612";
        if (DateUtils.isValidDateStr(timeFrom, DateUtils.YYYYMMDD)) {
            System.out.println("true");
        }
    }


    /**
     * 测试一个星期内的获取全部时间
     */
    public static void testFreeTime() {

        /**设置开始时间，结束时间，开始星期几，结束星期几，持续时间*/

        //星期一凌晨（开始时间）
        Calendar startCal = TimeUtils.getMondayAndAdd(0);

        //下个星期一凌晨，这个星期天的晚上（结束时间）
        Calendar endCal = TimeUtils.getMondayAndAdd(7);

        FreeTime freeTime = new FreeTime();
        //星期一（开始星期几）
        int startWeek = 0;
        //星期天（结束星期几）
        int endWeek = 6;

        //持续时间


        Map<Integer, List<Schedule>> listMap = freeTime.getAllTime(startCal, endCal, startWeek,
                endWeek, DURATION);

        int count = 0;
        for (int i = startWeek; i <= endWeek; i++) {
            List<Schedule> schedules = listMap.get(i);
            for (Schedule s : schedules) {
                System.out.println(s.getStartTime().getTime() + " -- " + s.getEndTime().getTime());
                count++;
            }
        }

        System.out.println("AllFreeTime Count: " + count);
        System.out.println(listMap);
    }


    /**
     * 测试一个星期内的所有空闲时间，既全部时间去除非空闲时间
     */
    public static Map<Integer, List<Schedule>> testAllFreeTime() {

        //星期一凌晨
        Calendar startCal = TimeUtils.getMondayAndAdd(0);

        //下个星期一凌晨，这个星期天的晚上
        Calendar endCal = TimeUtils.getMondayAndAdd(7);

        FreeTime freeTime = new FreeTime();
        //星期一
        int startWeek = 0;
        //星期天
        int endWeek = 6;

        Map<Integer, List<Schedule>> allTimeListMap = freeTime.getAllTime(startCal, endCal, startWeek,
                endWeek, DURATION);

        System.out.println("allTimeListMapSize:" + allTimeListMap.size() * allTimeListMap.get(0).size());

//        Map<Integer, List<Schedule>> notFreeTimeListMap = getNotFreeTime();
        Map<Integer, List<Schedule>> notFreeTimeListMap = getNotFreeTimeByAdd();

//        System.out.println("notFreeTimeListMapSize:" + notFreeTimeListMap.size() * notFreeTimeListMap.get(0).size());

        System.out.println("notFreeTimeListMapSize:" + notFreeTimeListMap.size());

        getAllFreeTime(allTimeListMap, notFreeTimeListMap);


//        for (int i = startWeek; i <= endWeek; i++) {
//            List<Schedule> schedules = allTimeListMap.get(i);
//            for (Schedule s : schedules) {
//                System.out.println(s.getStartTime().getTime() + " -*- " + s.getEndTime().getTime());
//            }
//        }

        return allTimeListMap;
    }


    /**
     * 获取所有的可用日程
     * 直接在allTime上修改，执行完成后allTime就是所有可用的日程
     *
     * @param allTime
     * @param busyTime
     * @return
     */
    public static void getAllFreeTime(Map<Integer, List<Schedule>> allTime, Map<Integer, List<Schedule>> busyTime) {
        FreeTime freeTime = new FreeTime();
        int count = 0;


        //由于allTime 和busyTime 都是map对象，比较size是为了比较天数是不是一样，不然没法比较，一般为7，既一个星期

//        if (allTime.size() == busyTime.size()) {
        for (int i = 0; i < allTime.size(); i++) {
            /**
             * 当然allTime和busyTime的size也可以不相等，但是要保证map的key要对应一致
             *
             */
            if (busyTime.size() <= i) {
                break;
            }
            List<Schedule> busyList = busyTime.get(i);
            for (Schedule busySchedule : busyList) {
                Iterator itr = allTime.get(i).iterator();
                while (itr.hasNext()) {
                    Schedule s = (Schedule) itr.next();
                    if (freeTime.judgeTimeOverlapByMills(s, busySchedule)) {
                        itr.remove();
                        count++;
                    }
                }
            }
        }
//        }

        System.out.println("remove count:" + count);

    }


    /**
     * 模拟测试-获取一个星期内每天固定时间段的非空闲时间
     *
     * @return
     */
    public static Map<Integer, List<Schedule>> getNotFreeTime() {
        Map<Integer, List<Schedule>> scheduleMap = new HashMap<Integer, List<Schedule>>();

        Calendar startCal = TimeUtils.getMondayAndAdd(0);
        for (int i = 0; i <= 6; i++) {
            List<Schedule> schedules = new ArrayList<Schedule>();
            Calendar endCal = (Calendar) startCal.clone();

            startCal.set(Calendar.HOUR_OF_DAY, 10);


            //下个星期一凌晨，这个星期天的晚上
            endCal.set(Calendar.HOUR_OF_DAY, 10);

            endCal.add(Calendar.MINUTE, 30);


//            Calendar start = Calendar.getInstance();
//            start.add(Calendar.DAY_OF_MONTH, i);
//            Calendar end = Calendar.getInstance();
//            end.add(Calendar.DAY_OF_MONTH, i);
//            end.add(Calendar.MINUTE, 30);
            System.out.println("not free start time:" + startCal.getTime());
            System.out.println("not free end time:" + endCal.getTime());

            Schedule schedule = new Schedule((Calendar) startCal.clone(), (Calendar) endCal.clone());
            schedules.add(schedule);
            scheduleMap.put(i, schedules);

            startCal.add(Calendar.DAY_OF_MONTH, 1);
            endCal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return scheduleMap;
    }


    /**
     * 模拟测试-获取**自定义**非空闲时间
     *
     * @return
     */
    public static Map<Integer, List<Schedule>> getNotFreeTimeByAdd() {
        Map<Integer, List<Schedule>> scheduleMap = new HashMap<Integer, List<Schedule>>();

        List<Schedule> schedules = new ArrayList<Schedule>();

        //第一个
        Calendar startCal1 = TimeUtils.getMondayAndAdd(0);
        Calendar endCal1 = (Calendar) startCal1.clone();
        startCal1.set(Calendar.HOUR_OF_DAY, 10);
        endCal1.set(Calendar.HOUR_OF_DAY, 10);
        endCal1.add(Calendar.MINUTE, 30);

        System.out.println("not free start time:" + startCal1.getTime());
        System.out.println("not free end time:" + endCal1.getTime());

        Schedule schedule1 = new Schedule((Calendar) startCal1.clone(), (Calendar) endCal1.clone());
        schedules.add(schedule1);
        scheduleMap.put(0, schedules);


        //第二个
        Calendar startCal2 = TimeUtils.getMondayAndAdd(1);
        Calendar endCal2 = (Calendar) startCal2.clone();
        startCal2.set(Calendar.HOUR_OF_DAY, 15);
        endCal2.set(Calendar.HOUR_OF_DAY, 15);
        endCal2.add(Calendar.MINUTE, 30);

        System.out.println("not free start time:" + startCal2.getTime());
        System.out.println("not free end time:" + endCal2.getTime());

        Schedule schedule2 = new Schedule((Calendar) startCal2.clone(), (Calendar) endCal2.clone());
        schedules.add(schedule2);
        scheduleMap.put(1, schedules);

        return scheduleMap;
    }


    /**
     * 获取用户偏好，特征向量求和
     * 目前还没有考虑加权
     *
     * @return
     */
    public static double[] genUserPreferences() {
        List<Schedule> list = new ArrayList<Schedule>();

        //20180514 星期一
        Calendar start3 = Calendar.getInstance();
        start3.set(2018, Calendar.MAY, 14, 9, 0);
        System.out.println(start3.getTime());
        Calendar end3 = Calendar.getInstance();
        end3.set(2018, Calendar.MAY, 14, 9, 50);
        System.out.println(end3.getTime());
        Schedule schedule3 = new Schedule(start3, end3);
        list.add(schedule3);


        //20180518 星期五
        Calendar start1 = Calendar.getInstance();
        start1.set(2018, Calendar.MAY, 18, 9, 0);
        System.out.println(start1.getTime());
        Calendar end1 = Calendar.getInstance();
        end1.set(2018, Calendar.MAY, 18, 9, 30);
        System.out.println(end1.getTime());
        Schedule schedule1 = new Schedule(start1, end1);
        list.add(schedule1);


        //20180519  星期六
        Calendar start2 = Calendar.getInstance();
        start2.set(2018, Calendar.MAY, 19, 9, 0);
        System.out.println(start2.getTime());
        Calendar end2 = Calendar.getInstance();
        end2.set(2018, Calendar.MAY, 19, 9, 30);
        System.out.println(end2.getTime());
        Schedule schedule2 = new Schedule(start2, end2);
        list.add(schedule2);

        double[] res = new double[24 * 6 + 4 + 7];

        for (Schedule s : list) {
            /**
             * Calendar.DAY_OF_WEEK  返回的是星期几+1
             * 貌似设置setFirstDayOfWeek()没法用呢。。。
             * 星期一返回2，所以要减去1
             * 又因为后面week数组是从零开始的，所以要-2
             */
            TimeFeature feature = new TimeFeature(s.getStartTime(),
                    (int) TimeUtils.calDistanceInMinutes(s.getStartTime().getTime(), s.getEndTime().getTime()),
                    s.getEndTime().get(Calendar.DAY_OF_WEEK) - 2);
            double[] v = vector(feature);
//            System.out.println("v:" + Arrays.toString(v));
            System.out.println("parse:" + parserVectorToFeature(v));
            addVetor(res, v);
        }

        System.out.println("res:" + Arrays.toString(res));

        return res;
    }


    /**
     * 测试计算top1的相似度
     */
    public static void testCalcSimTop() {
        Map<Integer, List<Schedule>> a = testAllFreeTime();

        calcSimTop(genUserPreferences(), a);
    }


    /**
     * 计算相似度最高的一个日程
     *
     * @param userPreference
     * @param listMap
     */
    public static void calcSimTop(double[] userPreference, Map<Integer, List<Schedule>> listMap) {

        double maxSim = 0;
        Schedule maxSimSchedule = null;
        for (int i = 0; i <= 6; i++) {
            List<Schedule> schedules = listMap.get(i);
            for (Schedule s : schedules) {
                //获取每个空闲schedule的向量
                System.out.println(s.getEndTime().getTime());
                TimeFeature feature = new TimeFeature(s.getStartTime(),
                        (int) TimeUtils.calDistanceInMinutes(s.getStartTime().getTime(), s.getEndTime().getTime()),
                        s.getEndTime().get(Calendar.DAY_OF_WEEK) - 2);

                //Calendar.DAY_OF_WEEK中星期天返回1，既星期天是一周的第一天，符合中国时间，需要特殊处理，在这里加5，既6代表星期天
                if(s.getEndTime().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                    feature = new TimeFeature(s.getStartTime(),
                            (int) TimeUtils.calDistanceInMinutes(s.getStartTime().getTime(), s.getEndTime().getTime()),
                            s.getEndTime().get(Calendar.DAY_OF_WEEK)+5);
                }


                double[] v = vector(feature);


                //计算相似度
                double sim = cosineSimilarity(userPreference, v);

                System.out.println("sim:" + sim);
                System.out.println("*****************************************************************");
                if (sim > maxSim) {
                    maxSim = sim;
                    maxSimSchedule = s;
                    System.out.println("||||||||"+feature.getStartTime().getTime());
                }
            }
        }
        System.out.println(maxSim);
        System.out.println(maxSimSchedule.getStartTime().getTime());

    }


    /**
     * 计算两个向量对应位相加
     * 直接在把b加到a上，a就是计算后的结果
     *
     * @param a
     * @param b
     * @return
     */
    public static void addVetor(double[] a, double[] b) {
        double[] c = new double[0];
        if (a.length != b.length) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + b[i];
        }
    }


    /**
     * 产生时间特征向量
     *
     * @param timeFeature
     * @return
     */
    private static double[] vector(TimeFeature timeFeature) {
        String startTime = timeFeature.getStartTimeStr();
        String duration = String.valueOf(timeFeature.getDuration());
        String week = String.valueOf(timeFeature.getWeek());

        double[] result = new double[24 * 6 + 4 + 7];

        /**
         * 开始时间特征向量
         * 时间粒度为10分钟
         * 数组从零点0分开始，既数组第一个元素代表的是0点0分
         */
        double[] startTimeVector = new double[24 * 6];
        String startTimeHour = "";
        String startTimeMinute = "";
        startTimeHour = startTime.split(":")[0];
        startTimeMinute = startTime.split(":")[1];
        // 56 / 10 == 5   50 / 10 == 5
        int startTimeMinuteIndex;
        if ("0".equals(startTimeMinute)) {
            startTimeMinuteIndex = 0;
        } else {
            startTimeMinuteIndex = Integer.parseInt(startTimeMinute) / 10;
//        startTimeMinuteIndex = Integer.parseInt(startTimeMinute) / 10 ;
        }

        for (int i = 0; i < 24; i++) {
            if (i == Integer.parseInt(startTimeHour)) {
                for (int j = 0; j < 6; j++) {
                    if (startTimeMinuteIndex == j) {
                        startTimeVector[i * 6 + j] = 1;
                    } else {
                        startTimeVector[i * 6 + j] = 0;
                    }
                }
            } else {
                for (int j = 0; j < 6; j++) {
                    startTimeVector[i * 6 + j] = 0;
                }
            }
        }

        System.out.println("startTime-num:" + startTimeHour);
        System.out.println("startTime-vetor:" + Arrays.toString(startTimeVector));

        /**
         * 持续时间
         * 15 30 1 2
         * 0  1  2 3
         */

        double[] durationVetor = new double[4];
        if (Integer.parseInt(duration) == 15) {
            durationVetor[0] = 1;
        } else if (Integer.parseInt(duration) == 30) {
            durationVetor[1] = 1;
        } else if (Integer.parseInt(duration) == 60) {
            durationVetor[2] = 1;
        } else if (Integer.parseInt(duration) == 120) {
            durationVetor[3] = 1;
        }

        System.out.println("duration-num:" + duration);
        System.out.println("duration-vector:" + Arrays.toString(durationVetor));


        /**
         * 周几
         * 0是星期一，1是星期二，。。。。。。
         */

        double[] weekVetor = new double[7];
        switch (Integer.parseInt(week)) {
            case 0:
                weekVetor[0] = 1;
                break;
            case 1:
                weekVetor[1] = 1;
                break;
            case 2:
                weekVetor[2] = 1;
                break;
            case 3:
                weekVetor[3] = 1;
                break;
            case 4:
                weekVetor[4] = 1;
                break;
            case 5:
                weekVetor[5] = 1;
                break;
            case 6:
                weekVetor[6] = 1;
                break;
            default:
        }

        System.out.println("week-num:" + week);
        System.out.println("week-vector:" + Arrays.toString(weekVetor));


        //拼接数组
        result = ArrayUtils.addAll(startTimeVector, durationVetor);
        result = ArrayUtils.addAll(result, weekVetor);

        System.out.println(Arrays.toString(result));

        return result;
    }


    /**
     * 计算两个向量的相似度
     *
     * @param vectorA
     * @param vectorB
     * @return
     */
    public static double cosineSimilarity(double[] vectorA, double[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }


    /**
     * 解析时间特征向量
     *
     * @param timeVetor
     * @return
     */
    public static String parserVectorToFeature(double[] timeVetor) {
        String result = "";
        double[] startTimeVetor = new double[24 * 6];
        double[] durationVetor = new double[4];
        double[] weekVetor = new double[7];

        int startTimeHour = 0;
        int startTimeMinuteIndex = 0;
        int startTimeMinute = 0;

        String startTime = "";
        String duration = "";
        String week = "";

        startTimeVetor = ArrayUtils.subarray(timeVetor, 0, 24 * 6);
        durationVetor = ArrayUtils.subarray(timeVetor, 24 * 6, 24 * 6 + 4);
        weekVetor = ArrayUtils.subarray(timeVetor, 24 * 6 + 4, timeVetor.length);

        for (int i = 0; i < startTimeVetor.length; i++) {
            if (startTimeVetor[i] == 0) {
                continue;
            }
            startTimeHour = i / 6;
            startTimeMinuteIndex = i % 6;
        }
//        startTimeMinute = (startTimeMinuteIndex + 1) * 10;
        startTimeMinute = (startTimeMinuteIndex) * 10;

        startTime = startTimeHour + ":" + startTimeMinute;
        System.out.println("startTimeHour:" + startTimeHour);
        System.out.println("startTimeMinute:" + startTimeMinute);


        //duration
        if (durationVetor[0] == 1) {
            duration = "15";
        } else if (durationVetor[1] == 1) {
            duration = "30";
        } else if (durationVetor[2] == 1) {
            duration = "60";
        } else if (durationVetor[3] == 1) {
            duration = "120";
        }


        //week
        for (int i = 0; i < weekVetor.length; i++) {
            if (weekVetor[i] == 0) {
                continue;
            }
            week = String.valueOf(i);
        }

//        System.out.println(Arrays.toString(timeVetor));
//        System.out.println(Arrays.toString(startTime));
//        System.out.println(Arrays.toString(duration));
//        System.out.println(Arrays.toString(week));

        result = startTime + "," + duration + "," + week;
        return result;

    }

}
