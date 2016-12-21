package com.webspider;

/**
 * Created by lenoovo on 2016/12/19.
 */
public class DataModelTask {

    private String TaskID;
    private String TaskState;
    private String GCTime;
    private String TaskDuration;
    private String StageID;
    private String StageDescripton;
    private String StageDuration;
    private String JobID;
    private String JobDescription;
    private String JobDuration;

    public String getTaskID() {
        return TaskID;
    }
    public void setTaskID(String taskID) {
        TaskID = taskID;
    }

    public String getTaskState() {
        return TaskState;
   }
   public void setTaskState(String taskState) {
        TaskState = taskState;
   }

    public String getGCTime() {
        return GCTime;
    }
    public void setGCTime(String GCTime) {
        this.GCTime = GCTime;
    }

    public String getTaskDuration() {
        return TaskDuration;
    }
    public void setTaskDuration(String taskDuration) {
        TaskDuration = taskDuration;
    }

    public String getStageID() {
        return StageID;
    }
    public void setStageID(String stageID) {
        StageID = stageID;
    }

    public String getJobID() {
        return JobID;
    }
    public void setJobID(String jobID) {
        JobID = jobID;
    }

    public String getJobDescription() {
        return JobDescription;
    }
    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }

    public void setJobDuration(String jobDuration) {
        JobDuration = jobDuration;
    }
    public String getJobDuration() {
        return JobDuration;
    }

    public String getStageDuration() {
        return StageDuration;
    }
    public void setStageDuration(String stageDuration) {
        StageDuration = stageDuration;
    }

    public String getStageDescripton() {
        return StageDescripton;
    }
    public void setStageDescripton(String stageDescripton) {
        StageDescripton = stageDescripton;
    }



    @Override
    public String toString() {
        return super.toString();
    }


}
