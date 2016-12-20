package com.webspider;

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
 * Created by lenoovo on 2016/12/19.
 */
public class StageSpiderVerOne {

    private String StageUrl;
    private List<DataModelStage>  dataModelStageList = new ArrayList<DataModelStage>();
    private Set<String> urlSet = new HashSet<String>();
    private Connection StageConnection = null;
    private String JobID;
   // private int StageCount;

    public String getStageUrl() {
        return StageUrl;
    }
    public void setStageUrl(String stageUrl) {
        StageUrl = stageUrl;
    }

    public List<DataModelStage> getDataModelStageList() {
        return dataModelStageList;
    }
    public void setDataModelStageList(List<DataModelStage> dataModelStageList) {
        this.dataModelStageList = dataModelStageList;
    }

    public Set<String> getUrlSet() {
        return urlSet;
    }
    public void setUrlSet(Set<String> urlSet) {
        this.urlSet = urlSet;
    }

    public String getJobID() {
        return JobID;
    }
    public void setJobID(String jobID) {
        JobID = jobID;
    }



    public void CaputerStageData(){
        try{
            StageConnection = Jsoup.connect(StageUrl);
            Document StageDocument = StageConnection.get();
            //System.out.println(StageUrl);



            Element Stagelis = StageDocument.getElementsByTag("table").first();
            Elements Stageliss = Stagelis.getElementsByTag("tr");
            //System.out.println(Stageliss.size());
            for (int i = 0; Stageliss != null && i <Stageliss.size(); i++) {
                Element li = Stageliss.get(i);
                Elements spans = li.getElementsByTag("td");
                if (spans != null && spans.size() == 9) {
                    DataModelStage dataModelStage = new DataModelStage();
                    dataModelStage.setStageID(spans.get(0).text());
                    dataModelStage.setJobID(getJobID());
                    dataModelStage.setStageDescription(spans.get(1).text());
                    dataModelStage.setStageDuration(spans.get(3).text());
                    Element lii = spans.get(1);
                    Elements spanss = lii.getElementsByTag("a");
                    dataModelStage.setTaskUrl(spanss.attr("abs:href"));
                    dataModelStageList.add(dataModelStage);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
