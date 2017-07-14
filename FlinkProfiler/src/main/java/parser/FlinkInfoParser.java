package parser;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import appInfo.FlinkInfo;
import com.google.gson.*;

import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by y81022857 on 2017/7/13.
 */
public class FlinkInfoParser {

    public FlinkInfo flinkInfo;
    private URL urlOverview;
    private URL urlConfig;

    public FlinkInfoParser(String url) throws IOException {

        this.urlOverview = new URL(url + "/overview");
        this.urlConfig = new URL(url + "/config");
        InfoParser();
    }

    public void InfoParser() throws IOException {


        this.flinkInfo = new FlinkInfo();


        HttpURLConnection connection = (HttpURLConnection) urlOverview.openConnection();
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
        System.out.println(s);

        try {

            JsonParser parser = new JsonParser();  //创建JSON解析器
            JsonElement el = parser.parse(s);
            JsonArray array = null;
            JsonObject overView = el.getAsJsonObject();
            //         System.out.println(overView.get("taskmanagers").getAsInt());
            //         System.out.println(overView.get("slots-total").getAsInt());


            flinkInfo.setTaskmanagers(overView.get("taskmanagers").getAsInt());
            flinkInfo.setTotalslots(overView.get("slots-total").getAsInt());
            flinkInfo.setUnUsedslots(overView.get("slots-available").getAsInt());
            flinkInfo.setRunningJobs(overView.get("jobs-running").getAsInt());
            flinkInfo.setFinishedJobs(overView.get("jobs-finished").getAsInt());
            flinkInfo.setFailedJobs(overView.get("jobs-failed").getAsInt());
            flinkInfo.setCancelledJobs(overView.get("jobs-cancelled").getAsInt());


        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }


        connection = (HttpURLConnection) urlConfig.openConnection();
        connection.setRequestMethod("GET");

        //line = null;
        //StringBuilder response = new StringBuilder();
        response = new StringBuilder();
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
        s = response.toString();
        System.out.println(s);

        try {

            JsonParser parser = new JsonParser();  //创建JSON解析器
            JsonElement el = parser.parse(s);
            //    JsonArray array = null;
            JsonObject overView = el.getAsJsonObject();
            //     System.out.println(overView.get("taskmanagers").getAsInt());
            //      System.out.println(overView.get("slots-total").getAsInt());


            flinkInfo.setInterval(overView.get("refresh-interval").getAsInt());
            flinkInfo.setOffset(overView.get("timezone-offset").getAsInt());
            flinkInfo.setVersion(overView.get("flink-version").getAsString());


        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        System.out.println(flinkInfo.toString());
    }


}







