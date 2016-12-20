package com.webspider;


import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws WriteException, IOException {
	// write your code here

        /*抓取Job页面的信息，并输出到表格中*/
        WebSpiderVerOne wsu1 = new WebSpiderVerOne();
        wsu1.setUrl("http://133.133.10.1:18080/history/app-20161217123107-0006/jobs/");
        long start = System.currentTimeMillis();
        wsu1.CaputerData();
        System.out.println("抓取数据共耗时:" + (System.currentTimeMillis() - start)/1000 + "秒");

        List<DataModel> Job = wsu1.getDataModelList();

        JxlUtil ju1= new JxlUtil();
        ju1.setPath("C:\\Users\\lenoovo\\model.xls");
        Map<String, List<List<String>>> listListMap1 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList1 = new ArrayList<List<String>>();
        List<String> list1 = new ArrayList<String>();
        list1.add("JobID");
        list1.add("JobDescription");
        list1.add("JobDuration");
        list1.add("URL");


        listList1.add(list1);
        for(int i=0;i<Job.size();i++){
            List<String> list11 = new ArrayList<String>();
            list11.add(Job.get(i).getJobID());
            list11.add(Job.get(i).getDescription());
            list11.add(Job.get(i).getDuration());
            list11.add(Job.get(i).getStageUrl());
          //  System.out.println(all.get(i).getStageUrl());
          //  System.out.println("wwwwwwwwwwwwww");
            listList1.add(list11);

        }

        listListMap1.put("Job History", listList1);
        ju1.write(listListMap1);

        /*抓取Stage页面的信息，并输出到表格中*/
        JxlUtil ju2= new JxlUtil();
        ju2.setPath("C:\\Users\\lenoovo\\modelStage.xls");
        Map<String, List<List<String>>> listListMap2 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList2 = new ArrayList<List<String>>();
        List<String> list2 = new ArrayList<String>();
        list2.add("JobID");
        list2.add("StageID");
        list2.add("StageDescription");
        list2.add("StageDuration");
        list2.add("Url");


        listList2.add(list2);
        StageSpiderVerOne wsu2 = new StageSpiderVerOne();
        for(int i=0;i<wsu1.getDataModelList().size();i++)
        {
            wsu2.setStageUrl(wsu1.getDataModelList().get(i).getStageUrl());
            wsu2.setJobID(wsu1.getDataModelList().get(i).getJobID());
            wsu2.CaputerStageData();

        }
        List<DataModelStage> Stage = wsu2.getDataModelStageList();
           for(int j=0;j<wsu2.getDataModelStageList().size();j++){
                List<String> list22 = new ArrayList<String>();
                list22.add(Stage.get(j).getJobID());
                list22.add(Stage.get(j).getStageID());
                list22.add(Stage.get(j).getStageDescription());
                list22.add(Stage.get(j).getStageDuration());
                list22.add(Stage.get(j).getTaskUrl());
                listList2.add(list22);
            }
        listListMap2.put("Stage History", listList2);
        ju2.write(listListMap2);

        /*抓取Task页面的信息，并输出到表格中*/
        JxlUtil ju3= new JxlUtil();
        ju3.setPath("C:\\Users\\lenoovo\\modelTask.xls");
        Map<String, List<List<String>>> listListMap3 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList3 = new ArrayList<List<String>>();
        List<String> list3 = new ArrayList<String>();
        list3.add("StageID");
        list3.add("TaskID");
        list3.add("TaskState");
        list3.add("GCTime");
        list3.add("Duration");


        listList3.add(list3);
        TaskSpiderVerOne wsu3 = new TaskSpiderVerOne();
        for(int i=0;i<wsu2.getDataModelStageList().size();i++)
        {
            wsu3.setTaskUrl(wsu2.getDataModelStageList().get(i).getTaskUrl());
         //   System.out.println(wsu2.getDataModelStageList().get(i).getTaskUrl());
            wsu3.setStageID(wsu2.getDataModelStageList().get(i).getStageID());
        //    System.out.println(wsu2.getDataModelStageList().get(i).getStageID());
            wsu3.CaputerTaskData();

        }
        List<DataModelTask> Task = wsu3.getDataModelTaskList();
        for(int j=0;j<wsu3.getDataModelTaskList().size();j++){
            List<String> list33 = new ArrayList<String>();
            list33.add(Task.get(j).getStageID());
        //    System.out.println(Task.get(j).getStageID());
            list33.add(Task.get(j).getTaskID());
            list33.add(Task.get(j).getTaskState());
            list33.add(Task.get(j).getGCTime());
            list33.add(Task.get(j).getTaskDuration());
            listList3.add(list33);
        }
        listListMap3.put("Stage History", listList3);
        ju3.write(listListMap3);






    }
}
