package com.webspider;

/**
 * Created by Xingtong YE on 2016/12/19.
 */

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.File;

import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Main {

    public static void main(String[] args) throws WriteException, IOException, BiffException {
        // write your code here

        JxlUtil ju1 = new JxlUtil();
        ju1.setPath("C:\\Users\\lenoovo\\model.xls");

        JxlUtil ju2 = new JxlUtil();
        ju2.setPath("C:\\Users\\lenoovo\\modelStage.xls");

        JxlUtil ju3 = new JxlUtil();
        ju3.setPath("C:\\Users\\lenoovo\\modelTask.xls");

        /*Get Job Information from the Web Page and Write it into Excel*/

        WebSpiderVerOne wsu1 = new WebSpiderVerOne();
        wsu1.setUrl("http://133.133.10.1:18080/history/app-20161222092026-0044/jobs/");
        wsu1.CaputerData();
        List<DataModel> Job = wsu1.getDataModelList();

        Map<String, List<List<String>>> listListMap1 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList1 = new ArrayList<List<String>>();
        List<String> list1 = new ArrayList<String>();
        list1.add("JobID");
        list1.add("JobDescription");
        list1.add("JobDuration");
        // list1.add("URL");

        listList1.add(list1);
        for (int i = 0; i < Job.size(); i++) {
            List<String> list11 = new ArrayList<String>();
            list11.add(Job.get(i).getJobID());
            list11.add(Job.get(i).getDescription());
            list11.add(Job.get(i).getDuration());
            listList1.add(list11);
        }

        listListMap1.put("Job History", listList1);
        ju1.write(listListMap1);

        /*Get Stage Information from the Web Page and Write it into Excel*/

        Map<String, List<List<String>>> listListMap2 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList2 = new ArrayList<List<String>>();
        List<String> list2 = new ArrayList<String>();
        list2.add("JobID");
        list2.add("JobDescription");
        list2.add("JobDuration");
        list2.add("StageID");
        list2.add("StageDescription");
        list2.add("StageDuration");

        listList2.add(list2);
        StageSpiderVerOne wsu2 = new StageSpiderVerOne();
        for (int i = 0; i < wsu1.getDataModelList().size(); i++) {
            wsu2.setStageUrl(wsu1.getDataModelList().get(i).getStageUrl());
            wsu2.setJobID(wsu1.getDataModelList().get(i).getJobID());
            wsu2.setJobDescription(wsu1.getDataModelList().get(i).getDescription());
            wsu2.setJobDuration(wsu1.getDataModelList().get(i).getDuration());
            wsu2.CaputerStageData();
        }
        List<DataModelStage> Stage = wsu2.getDataModelStageList();
        for (int j = 0; j < wsu2.getDataModelStageList().size(); j++) {
            List<String> list22 = new ArrayList<String>();
            list22.add(Stage.get(j).getJobID());
            list22.add(Stage.get(j).getJobDescription());
            list22.add(Stage.get(j).getJobDuraion());
            list22.add(Stage.get(j).getStageID());
            list22.add(Stage.get(j).getStageDescription());
            list22.add(Stage.get(j).getStageDuration());
            //          list22.add(Stage.get(j).getTaskUrl());
            listList2.add(list22);
        }
        listListMap2.put("Stage History", listList2);
        ju2.write(listListMap2);

        /*Get Task Information from the Web Page and Write it into Excel*/

        Map<String, List<List<String>>> listListMap3 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList3 = new ArrayList<List<String>>();
        List<String> list3 = new ArrayList<String>();
        list3.add("JobID");
        list3.add("JobDescription");
        list3.add("JobDuration");
        list3.add("StageID");
        list3.add("StageDescription");
        list3.add("StageDuration");
        list3.add("TaskID");
        list3.add("TaskState");
        list3.add("GCTime");
        list3.add("Duration");

        listList3.add(list3);
        TaskSpiderVerOne wsu3 = new TaskSpiderVerOne();

        DefaultCategoryDataset ds = new DefaultCategoryDataset();

        for (int i = 0; i < wsu2.getDataModelStageList().size(); i++) {
            wsu3.setTaskUrl(wsu2.getDataModelStageList().get(i).getTaskUrl());
            wsu3.setJobID(wsu2.getDataModelStageList().get(i).getJobID());
            wsu3.setJobDescription(wsu2.getDataModelStageList().get(i).getJobDescription());
            wsu3.setJobDuration(wsu2.getDataModelStageList().get(i).getJobDuraion());
            wsu3.setStageID(wsu2.getDataModelStageList().get(i).getStageID());
            wsu3.setStageDescripton(wsu2.getDataModelStageList().get(i).getStageDescription());
            wsu3.setStageDuration(wsu2.getDataModelStageList().get(i).getStageDuration());
            wsu3.CaputerTaskData();
        }
        List<DataModelTask> Task = wsu3.getDataModelTaskList();
        for (int j = 0; j < wsu3.getDataModelTaskList().size(); j++) {
            List<String> list33 = new ArrayList<String>();
            list33.add(Task.get(j).getJobID());
            list33.add(Task.get(j).getJobDescription());
            list33.add(Task.get(j).getJobDuration());
            list33.add(Task.get(j).getStageID());
            list33.add(Task.get(j).getStageDescripton());
            list33.add(Task.get(j).getStageDuration());
            list33.add(Task.get(j).getTaskID());
            list33.add(Task.get(j).getTaskState());
            list33.add(Task.get(j).getGCTime());
            list33.add(Task.get(j).getTaskDuration());
            listList3.add(list33);

            String temp = Task.get(j).getGCTime();
            char[] chs = temp.toCharArray();
            int len = chs.length;
            int time;
            if (len == 0)
                time = 0;
            else {
                if (chs[len - 1] == 's' && chs[len - 2] == 'm') {
                    String temp1 = temp.substring(0, temp.indexOf(" "));
                    time = Integer.parseInt(temp1);
                } else {
                    if (chs[len - 1] == 's' && chs[len - 2] != 'm') {
                        String temp1 = temp.substring(0, temp.indexOf("."));
                        String temp2 = temp.substring(temp.indexOf(".") + 1, temp.indexOf(" "));
                        int len2 = temp2.length();
                        int time1, time2;
                        time1 = Integer.parseInt(temp1);
                        time2 = Integer.parseInt(temp2);
                        time = time1 * 60 + time2 * 60 / (len2 * 10);
                    } else
                        time = 0;
                }
            }
            // System.out.println(time);
            if (time != 0)
                ds.addValue(time, Task.get(j).getTaskID(), "GC Time");
        }
        listListMap3.put("Task History", listList3);
        ju3.write(listListMap3);

        JFreeChart chart = ChartFactory.createBarChart("GC Time Summary", "TaskID", "Time(ms)",
                ds, PlotOrientation.VERTICAL, true, true, true);

        CategoryPlot cp = chart.getCategoryPlot();
        cp.setBackgroundPaint(ChartColor.WHITE); // 背景色设置
        cp.setRangeGridlinePaint(ChartColor.GRAY); // 网格线色设置
        ChartUtilities.saveChartAsPNG(new File("D:\\ColumnChart.png"),
                chart, 800, 500);


    }
}
