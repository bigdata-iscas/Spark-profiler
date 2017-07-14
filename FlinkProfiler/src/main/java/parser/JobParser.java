package parser;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by y81022857 on 2017/7/14.
 */
public class JobParser {


    private List<String> completedList = new ArrayList<String>();
    private List<String> runningList = new ArrayList<String>();
    private List<String> canceledList = new ArrayList<String>();
    private List<String> failedList = new ArrayList<String>();

    public JobParser(String url) throws IOException {

        URL urlJob = new URL(url + "/jobs");
        HttpURLConnection connection = (HttpURLConnection) urlJob.openConnection();
        connection.setRequestMethod("GET");

        String line = null;
        StringBuilder response = new StringBuilder();
        try {
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\r\n");
                continue;
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        String s = response.toString();
        //   System.out.println(s);

        try {

            JsonParser parser = new JsonParser();  //创建JSON解析器
            JsonElement el = parser.parse(s);

            JsonArray array = null;
            if (el.isJsonArray()) {
                array = el.getAsJsonArray();
                System.out.print(1111);
            }
            //    System.out.print(el);

            JsonObject subObject = el.getAsJsonObject();

//            System.out.println(array.size());
            for (int i = 0; i < 3; i++) {
                //       JsonObject subObject = array.get(i).getAsJsonObject();
                //  JsonArray subsubObject = subObject.get("jobs-running").getAsJsonObject().getAsJsonArray();
                switch (i) {

                    case 0:
                        JsonArray subsubObject = subObject.get("jobs-running").getAsJsonArray();
                        System.out.println(subsubObject.size());
                        for (int j = 0; j < subsubObject.size(); j++)
                            runningList.add(subsubObject.get(j).getAsString());
                        break;
                    case 1:
                        subsubObject = subObject.get("jobs-finished").getAsJsonArray();
                        System.out.println(subsubObject.size());
                        for (int j = 0; j < subsubObject.size(); j++)
                            // System.out.println(subsubObject.get(j));
                            completedList.add(subsubObject.get(j).getAsString());
                        //     completedList.add(subObject.getAsString());
                        break;
                    case 2:
                        subsubObject = subObject.get("jobs-cancelled").getAsJsonArray();
                        for (int j = 0; j < subsubObject.size(); j++)
                            // System.out.println(subsubObject.get(j).getAsString());
                            canceledList.add(subsubObject.get(j).getAsString());
                        // canceledList.add(subObject.getAsString());
                        break;
                    case 3:
                        subsubObject = subObject.get("jobs-failed").getAsJsonArray();
                        for (int j = 0; j < subsubObject.size(); j++)
                            //  System.out.println(subsubObject.get(j).getAsString());
                            failedList.add(subsubObject.get(j).getAsString());


                }
            }

        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

//        System.out.print(completedList.size());
        for (int i = 0; i < completedList.size(); i++)
            System.out.println(completedList.get(i));
        System.out.println("==========================");
        for (int i = 0; i < runningList.size(); i++)
            System.out.println(runningList.get(i));
        System.out.println("==========================");
        for (int i = 0; i < canceledList.size(); i++)
            System.out.println(canceledList.get(i));
        System.out.println("==========================");
        for (int i = 0; i < failedList.size(); i++)
            System.out.println(failedList.get(i));

    }

    public List<String> getCompletedList() {
        return completedList;
    }

    public void setCompletedList(List<String> completedList) {
        this.completedList = completedList;
    }

    public List<String> getRunningList() {
        return runningList;
    }

    public void setRunningList(List<String> runningList) {
        this.runningList = runningList;
    }

    public List<String> getCanceledList() {
        return canceledList;
    }

    public void setCanceledList(List<String> canceledList) {
        this.canceledList = canceledList;
    }

    public List<String> getFailedList() {
        return failedList;
    }

    public void setFailedList(List<String> failedList) {
        this.failedList = failedList;
    }
}
