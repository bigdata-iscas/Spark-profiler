package com.webspider;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * Created by lenoovo on 2016/12/20.
 */
public class TaskSpiderVerOne {

    private String TaskUrl;
    private List<DataModelTask> dataModelTaskList = new ArrayList<DataModelTask>();
    private Connection TaskConnection = null;
    private String StageID;

    public String getTaskUrl() {
        return TaskUrl;
    }
    public void setTaskUrl(String taskUrl) {
        TaskUrl = taskUrl;
    }

    public List<DataModelTask> getDataModelTaskList() {
        return dataModelTaskList;
    }
    public void setDataModelTaskList(List<DataModelTask> dataModelTaskList) {
        this.dataModelTaskList = dataModelTaskList;
    }

    public String getStageID() {
        return StageID;
    }
    public void setStageID(String stageID) {
        StageID = stageID;
    }

    public void CaputerTaskData(){
        try{

            TaskConnection = Jsoup.connect(TaskUrl);
            Document TaskDocument = TaskConnection.get();
            //System.out.println(StageUrl);

            Element Tasklis = TaskDocument.getElementsByTag("table").last();
            Elements Taskliss = Tasklis.getElementsByTag("tr");
            //System.out.println(Taskliss.size());
            for (int i = 0; Taskliss != null && i <Taskliss.size(); i++) {
                Element li = Taskliss.get(i);
                Elements spans = li.getElementsByTag("td");
                if (spans != null && spans.size()>=16 ) {
                    DataModelTask dataModelTask = new DataModelTask();
                    dataModelTask.setTaskID(spans.get(1).text());
                    //System.out.println(spans.get(1).text());
                    dataModelTask.setStageID(getStageID());
                    //System.out.println(getStageID());
                    dataModelTask.setTaskState(spans.get(3).text());
                    //System.out.println(spans.get(3).text());
                    dataModelTask.setTaskDuration(spans.get(7).text());
                    //System.out.println(spans.get(7).text());
                    dataModelTask.setGCTime(spans.get(10).text());
                    dataModelTaskList.add(dataModelTask);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
