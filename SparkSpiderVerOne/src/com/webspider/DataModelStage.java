package com.webspider;

/**
 * Created by lenoovo on 2016/12/19.
 */
public class DataModelStage {

    private String StageID;
    private String StageDescription;
    private String StageDuration;
    private String TaskUrl;
    private String JobID;
    //private int StageCount;

    public String getStageID() {
        return StageID;
    }

    public void setStageID(String stageID) {
        StageID = stageID;
    }

    public String getStageDescription() {
        return StageDescription;
    }

    public void setStageDescription(String stageDescription) {
        StageDescription = stageDescription;
    }

    public String getStageDuration() {
        return StageDuration;
    }

    public void setStageDuration(String stageDuration) {
        StageDuration = stageDuration;
    }

    public String getTaskUrl() {
        return TaskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        TaskUrl = taskUrl;
    }

    public String getJobID() {
        return JobID;
    }

    public void setJobID(String jobID) {
        JobID = jobID;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}