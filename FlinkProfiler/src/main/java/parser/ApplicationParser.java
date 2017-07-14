package parser;

import appInfo.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import appInfo.vertices;
import com.google.gson.*;


/**
 * Created by y81022857 on 2017/7/14.
 */
public class ApplicationParser {

    //private List<applications> applicationsList = new ArrayList<applications>();

    private applications applications = new applications();

    private URL url;
    //private URL urlComplete;

    public ApplicationParser(String url,String jobID) throws IOException {

        this.url = new URL(url + "/jobs/"+jobID);
        AppParser();
    }


    public void AppParser() throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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

            //System.out.println(array.size());

            JsonObject jsonObject = el.getAsJsonObject();

            applications.setJobID(jsonObject.get("jid").getAsString());
            applications.setJobName(jsonObject.get("name").getAsString());
            applications.setJobState(jsonObject.get("state").getAsString());
            applications.setStartTime(jsonObject.get("start-time").getAsLong());
            applications.setEndTime(jsonObject.get("end-time").getAsLong());
            applications.setNowTime(jsonObject.get("now").getAsLong());
            applications.setDuration(jsonObject.get("duration").getAsLong());

         //   JsonObject subObject = jsonObject.get("vertices").getAsJsonObject();
            JsonArray jsonArray = jsonObject.get("vertices").getAsJsonArray();
            for(int i =0;i<jsonArray.size();i++)
            {
                vertices vertices = new vertices();
                vertices.setVerticesId(jsonArray.get(i).getAsJsonObject().get("id").getAsString());
                vertices.setVerticesName(jsonArray.get(i).getAsJsonObject().get("name").getAsString());
                vertices.setParallelism(jsonArray.get(i).getAsJsonObject().get("parallelism").getAsInt());
                vertices.setStartTime(jsonArray.get(i).getAsJsonObject().get("start-time").getAsInt());
                vertices.setEndTime(jsonArray.get(i).getAsJsonObject().get("end-time").getAsInt());
                vertices.setDuration(jsonArray.get(i).getAsJsonObject().get("duration").getAsInt());

                applications.getVertices().add(vertices);
            }


            System.out.println("id=" + applications.getJobID());
            System.out.println("name=" + applications.getJobName());
            System.out.println("state=" + applications.getJobState());
            System.out.println("start-time=" + applications.getStartTime());
            System.out.println("end-time=" + applications.getEndTime());
            System.out.println("duration=" + applications.getDuration());
            System.out.println("now="+ applications.getNowTime());
            System.out.println("++++++++++++++++++++");
            for(int i=0;i<applications.getVertices().size();i++)
            {

                System.out.println(applications.getVertices().get(i).toString());


            }



        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }


}
