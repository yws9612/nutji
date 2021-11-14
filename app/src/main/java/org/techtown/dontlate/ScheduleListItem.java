package org.techtown.dontlate;

public class ScheduleListItem {

    String StartTime;
    String EndTime;
    String ScheduleName;
    String ScheduleMemo;

    public  ScheduleListItem() {
        this.StartTime = "시작 시간";
        this.EndTime = "종료 시간";
        this.ScheduleName = "일정 이름";
        this.ScheduleMemo = "일정 내용";
    }

    public ScheduleListItem(String start, String end, String name, String memo) {
        this.StartTime = start;
        this.EndTime = end;
        this.ScheduleName = name;
        this.ScheduleMemo = memo;
    }

    public String getStartTime() { return StartTime; }
    public void setStartTime(String start) { this.StartTime = start; }

    public String getEndTime() { return EndTime; }
    public void setEndTime(String end) { this.EndTime = end; }

    public String getScheduleName() { return ScheduleName; }
    public void setScheduleName(String name) { this.ScheduleName = name; }

    public String getScheduleMemo() { return ScheduleMemo; }
    public void setScheduleMemo(String memo) { this.ScheduleMemo = memo; }

    @Override
    public String toString() {
        return "{" +
                "StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", ScheduleName='" + ScheduleName + '\'' +
                ", ScheduleMemo='" + ScheduleMemo + '\'' +
                '}';
    }

}
