import java.awt.print.PrinterGraphics;
import java.util.Calendar;
import java.util.Date;

/**
 * @author LiGuanglong
 * @date 2018/5/13
 */
public class TimeFeature {

    private Calendar startTime;

    private int duration;

    private int week;

    public TimeFeature(Calendar startTime, int duration, int week) {
        this.startTime = startTime;
        this.duration = duration;
        this.week = week;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getStartTimeStr(){
        return this.startTime.get(Calendar.HOUR_OF_DAY) + ":" + this.startTime.get(Calendar.MINUTE);
    }
}
