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


    @Override
    public String toString() {
        return super.toString();
    }


}
