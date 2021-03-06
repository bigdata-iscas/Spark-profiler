import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WriteException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ye on 2017/2/14.
 * Modified by YE on 2017/3/20.
 */
public class Main {
    public static void main(String args[]) throws IOException, WriteException {

        JxlUtil ju1 = new JxlUtil();
        String appid = "app-20170303221602-0006";
        ju1.setPath("C:\\Users\\TTTTJob.xls");

        JxlUtil ju2 = new JxlUtil();
        ju2.setPath("C:\\Users\\TTTTStage.xls");

        JxlUtil ju3 = new JxlUtil();
        ju3.setPath("C:\\Users\\TTTTTTask.xls");


        ReadJobJSON read1 = new ReadJobJSON();
        read1.setJobUrl(appid);
        read1.jobwsu();
        List<Jobs> job = read1.getJobsList();

        Map<String, List<List<String>>> listListMap1 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList1 = new ArrayList<List<String>>();
        List<String> list1 = new ArrayList<String>();
        list1.add("JobID");
        list1.add("JobDescription");
        list1.add("StageID");
        list1.add("SubmitTime");
        list1.add("CompleteTime");
        list1.add("JobDuration/s");
        listList1.add(list1);

        for (int i = 0; i < job.size(); i++) {
            List<String> list11 = new ArrayList<String>();
            list11.add(job.get(i).getJobID());
            list11.add(job.get(i).getName());
            list11.add(job.get(i).getStageID());
            list11.add(job.get(i).getSubmitTime());
            list11.add(job.get(i).getCompleteTime());
            list11.add(job.get(i).getDuration());
            listList1.add(list11);
        }

        listListMap1.put("Job History", listList1);
        ju1.write(listListMap1);

        ReadStageJSON read2 = new ReadStageJSON();
        read2.setStageUrl(appid);
        read2.stagewsu();
        List<Stages> stage = read2.getStagesList();

        Map<String, List<List<String>>> listListMap2 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList2 = new ArrayList<List<String>>();
        List<String> list2 = new ArrayList<String>();
        list2.add("StageID");
        list2.add("StageDescription");
        list2.add("SubmitTime");
        list2.add("CompleteTime");
        list2.add("StageDuration/s");
        list2.add("numCompleteTasks");
        list2.add("attemptID");
        list2.add("status");

        listList2.add(list2);


        for (int j = 0; j < stage.size(); j++) {
            List<String> list22 = new ArrayList<String>();
            list22.add(stage.get(j).getStageId());
            list22.add(stage.get(j).getName());
            list22.add(stage.get(j).getSubmitTime());
            list22.add(stage.get(j).getCompleteTime());
            list22.add(stage.get(j).getDuration());
            list22.add(stage.get(j).getNumCompleteTasks());
            list22.add(stage.get(j).getAttemptId());
          //  System.out.println(stage.get(j).getAttemptId());
            list22.add(stage.get(j).getStatus());

            listList2.add(list22);
        }
        listListMap2.put("Stage History", listList2);
        ju2.write(listListMap2);

        ReadTaskJSON read3 = new ReadTaskJSON();
        for(int i=0;i<stage.size();i++)
        {
            System.out.println(stage.get(i).getTaskUrl());
            read3.setTaskUrl(stage.get(i).getTaskUrl());
            read3.setStageId(stage.get(i).getStageId());
            read3.setStageStatus(stage.get(i).getStatus());
            read3.taskwsu();
        }

        List<Tasks> task = read3.getTasksList();

        Map<String, List<List<String>>> listListMap3 = new HashMap<String, List<List<String>>>();
        List<List<String>> listList3 = new ArrayList<List<String>>();
        List<String> list3 = new ArrayList<String>();
        list3.add("TaskID");
        list3.add("TaskStatus");
        list3.add("StageID");
        list3.add("ExecutorID");
        list3.add("GC Time/ms");
        list3.add("Duration/ms");
        list3.add("stageStatus");
        //   list1.add("StageID");
        listList3.add(list3);
        for (int i = 0; i < task.size(); i++) {
            List<String> list33 = new ArrayList<String>();
            list33.add(task.get(i).getTaskId());
            list33.add(task.get(i).getTaskStatus());
            list33.add(task.get(i).getStageId());
            list33.add(task.get(i).getExecutorId());
            list33.add(task.get(i).getJvmGcTime());
            list33.add(task.get(i).getExecutorRunTime());
            list33.add(task.get(i).getStageStatus());

            listList3.add(list33);
        }

        listListMap3.put("Job History", listList3);
        ju3.write(listListMap3);

    }
}
