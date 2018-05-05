import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author LiGuanglong
 * @date 2018/5/5
 */
public class Main {

    public static void main(String[] args) {

        String s1 = "1:40,30,3";
        double[] v1 = vector(s1);

        String s2 = "1:50,30,3";
        double[] v2 = vector(s2);


        String s3 = "8:50,60,4";
        double[] v3 = vector(s3);

        String s4 = "8:50,30,4";
        double[] v4 = vector(s4);

        System.out.println(cosineSimilarity(v1, v2));

        System.out.println(cosineSimilarity(v1, v3));

        System.out.println(cosineSimilarity(v4, v3));


        System.out.println("aaa\\n");
        System.out.println("bbb");


    }

    private static double[] vector(String v) {
        String startTime = "";
        String duration = "";
        String week = "";
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(v.split(",")));

        startTime = arrayList.get(0);
        duration = arrayList.get(1);
        week = arrayList.get(2);

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
        int startTimeMinuteIndex = Integer.parseInt(startTimeMinute) / 10 - 1;
        for (int i = 0; i < 3; i++) {
            if (i == Integer.parseInt(startTimeHour)) {
                for (int j = 0; j < 24; j++) {
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

}
