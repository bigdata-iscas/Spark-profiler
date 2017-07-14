package appInfo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by y81022857 on 2017/7/13.
 */
public class applications {

    /*
    Get Information from http://localhost:8081/joboverview/running
    */

    private String jobID;
    private String jobName;
    private String jobState;
    private long startTime;
    private long endTime;
    private long duration;
    private long nowTime;
    private String totalTasks;
    private String pendingTasks;
    private String runningTasks;
    private String finishedTasks;
    private String cancelingTasks;
    private String canceledTasks;
    private String failedTasks;
    private List<vertices> vertices = new ArrayList<appInfo.vertices>();


    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }


    public String getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(String totalTasks) {
        this.totalTasks = totalTasks;
    }

    public String getPendingTasks() {
        return pendingTasks;
    }

    public void setPendingTasks(String pendingTasks) {
        this.pendingTasks = pendingTasks;
    }

    public String getRunningTasks() {
        return runningTasks;
    }

    public void setRunningTasks(String runningTasks) {
        this.runningTasks = runningTasks;
    }

    public String getFinishedTasks() {
        return finishedTasks;
    }

    public void setFinishedTasks(String finishedTasks) {
        this.finishedTasks = finishedTasks;
    }

    public String getCancelingTasks() {
        return cancelingTasks;
    }

    public void setCancelingTasks(String cancelingTasks) {
        this.cancelingTasks = cancelingTasks;
    }

    public String getCanceledTasks() {
        return canceledTasks;
    }

    public void setCanceledTasks(String canceledTasks) {
        this.canceledTasks = canceledTasks;
    }

    public String getFailedTasks() {
        return failedTasks;
    }

    public void setFailedTasks(String failedTasks) {
        this.failedTasks = failedTasks;
    }


    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getNowTime() {
        return nowTime;
    }

    public void setNowTime(long nowTime) {
        this.nowTime = nowTime;
    }

    public List<appInfo.vertices> getVertices() {
        return vertices;
    }

    public void setVertices(List<appInfo.vertices> vertices) {
        this.vertices = vertices;
    }

    @Override
    public String toString() {
        return "applications{" +
                "jobID='" + jobID + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobState='" + jobState + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                ", nowTime=" + nowTime +
                ", totalTasks='" + totalTasks + '\'' +
                ", pendingTasks='" + pendingTasks + '\'' +
                ", runningTasks='" + runningTasks + '\'' +
                ", finishedTasks='" + finishedTasks + '\'' +
                ", cancelingTasks='" + cancelingTasks + '\'' +
                ", canceledTasks='" + canceledTasks + '\'' +
                ", failedTasks='" + failedTasks + '\'' +
                ", vertices=" + vertices +
                '}';
    }
}
