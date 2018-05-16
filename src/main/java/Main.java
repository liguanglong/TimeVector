import org.apache.commons.lang3.ArrayUtils;

import java.awt.datatransfer.StringSelection;
import java.util.*;

/**
 * @author LiGuanglong
 * @date 2018/5/5
 */
public class Main {

    public static void main(String[] args) {
        /**
         * TimeFeature格式:(时间，持续时间，星期几)
         */

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

        System.out.println("q34"+"\r\n"+"asdf");



    }

    public static void testFreeTime() {
        Calendar startCal = Calendar.getInstance();
        startCal.set(2018, Calendar.MAY, 13, 8, 0);
        Calendar endCal = Calendar.getInstance();
        endCal.set(2018, Calendar.MAY, 13, 22, 0);

        FreeTime freeTime = new FreeTime();
        int startWeek = 0;
        int endWeek = 6;
        Map<Integer, List<Schedule>> listMap = freeTime.getAllTime(startCal, endCal, startWeek, endWeek, 30);

        for (int i = startWeek; i < endWeek; i++) {
            List<Schedule> schedules = listMap.get(i);
            for (Schedule s : schedules) {
                System.out.println(s.getStartTime().getTime() + " -- " + s.getEndTime().getTime());
            }
        }

        System.out.println(listMap);
    }


    /**
     * 产生日程列表，既产生非空闲时间
     *
     * @return
     */
    public static Map<Integer, List<Schedule>> genSchedule() {
        Map<Integer, List<Schedule>> listMap = new HashMap<Integer, List<Schedule>>(16);
        Calendar startCal = Calendar.getInstance();
        startCal.set(2018, Calendar.MAY, 13, 8, 30);
        Calendar endCal = Calendar.getInstance();
        endCal.set(2018, Calendar.MAY, 13, 10, 0);

        return listMap;
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
         * 数组从零点10分开始，既数组第一个元素代表的是0点10分
         */
        double[] startTimeVector = new double[24 * 6];
        String startTimeHour = "";
        String startTimeMinute = "";
        startTimeHour = startTime.split(":")[0];
        startTimeMinute = startTime.split(":")[1];
        // 56 / 10 == 5   50 / 10 == 5
        int startTimeMinuteIndex = Integer.parseInt(startTimeMinute) / 10 - 1;

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

        System.out.println("startTime:");
        System.out.println(Arrays.toString(startTimeVector));

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

        System.out.println("duration:" + Arrays.toString(durationVetor));


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

        System.out.println("week" + Arrays.toString(weekVetor));

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
        startTimeMinute = (startTimeMinuteIndex + 1) * 10;

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
