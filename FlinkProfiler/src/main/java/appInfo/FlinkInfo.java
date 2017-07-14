package appInfo;

/**
 * Created by y81022857 on 2017/7/13.
 */


public class FlinkInfo {


    /*
    Information From
    http://localhost:8081/config
    http://localhost:8081/overview
    DataStructure of Flink Config & Basic Info
    */

    private int interval; //refresh interval
    private int offset;  //timezone offset
    private String name;    //timezone name
    private String version;   //flink version


    private int taskmanagers;
    private int totalslots;
    private int unUsedslots;
    private int runningJobs;
    private int finishedJobs;
    private int cancelledJobs;
    private int failedJobs;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getTaskmanagers() {
        return taskmanagers;
    }

    public void setTaskmanagers(int taskmanagers) {
        this.taskmanagers = taskmanagers;
    }

    public int getTotalslots() {
        return totalslots;
    }

    public void setTotalslots(int totalslots) {
        this.totalslots = totalslots;
    }

    public int getUnUsedslots() {
        return unUsedslots;
    }

    public void setUnUsedslots(int unUsedslots) {
        this.unUsedslots = unUsedslots;
    }

    public int getRunningJobs() {
        return runningJobs;
    }

    public void setRunningJobs(int runningJobs) {
        this.runningJobs = runningJobs;
    }

    public int getFinishedJobs() {
        return finishedJobs;
    }

    public void setFinishedJobs(int finishedJobs) {
        this.finishedJobs = finishedJobs;
    }

    public int getCancelledJobs() {
        return cancelledJobs;
    }

    public void setCancelledJobs(int cancelledJobs) {
        this.cancelledJobs = cancelledJobs;
    }

    public int getFailedJobs() {
        return failedJobs;
    }

    public void setFailedJobs(int failedJobs) {
        this.failedJobs = failedJobs;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "FlinkInfo{" +
                "interval='" + interval + '\'' +
                ", offset='" + offset + '\'' +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", taskmanagers=" + taskmanagers +
                ", totalslots=" + totalslots +
                ", unUsedslots=" + unUsedslots +
                ", runningJobs=" + runningJobs +
                ", finishedJobs=" + finishedJobs +
                ", cancelledJobs=" + cancelledJobs +
                ", failedJobs=" + failedJobs +
                '}';
    }
}
