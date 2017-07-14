import appInfo.FlinkInfo;
import parser.ApplicationParser;
import parser.FlinkInfoParser;
import parser.JobParser;

import java.io.IOException;
import java.util.List;

/**
 * Created by y81022857 on 2017/7/13.
 */
public class FlinkParser {

    public static void main(String args[]) throws IOException {


        String url;
        url = "http://127.0.0.1:8081";

        FlinkInfoParser flinkInfoParser = new FlinkInfoParser(url);

        JobParser jobParser = new JobParser(url);

        List<String>  jobList = jobParser.getCompletedList();

        for(int i=0;i<jobList.size();i++)
        {
            ApplicationParser applicationParser = new ApplicationParser(url,jobList.get(i));


        }




    }
}
