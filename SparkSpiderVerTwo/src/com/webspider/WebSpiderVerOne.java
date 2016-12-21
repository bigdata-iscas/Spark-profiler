package com.webspider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by lenoovo on 2016/12/19.
 */
public class WebSpiderVerOne {

    private String url;
    private List<DataModel> dataModelList = new ArrayList<DataModel>();//设置list，每一个list存储一个job的信息
   // private Set<String> urlSet = new HashSet<String>();//设置set，每个job对应一个Stage页面，所以需要获取对应stage页面的url
    private Connection connection = null;
   private Elements links = null;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public List<DataModel> getDataModelList() {
        return dataModelList;
    }
    public void setDataModelList(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

   /* public Set<String> getUrlSet() {
        return urlSet;
    }
    public void setUrlSet(Set<String> urlSet) {
        this.urlSet = urlSet;
    }*/

    public Elements getLinks() {
        return links;
    }

    public void CaputerData() throws IOException {
        try{
            connection = Jsoup.connect(url);
            Document document = connection.get();

          /*  Elements resultUrls = document.getElementsByClass("description-input");
            Elements links = null;
            for(Element resultUrl : resultUrls)
                links = resultUrl.getElementsByTag("a");*/

        //    links = document.select("span.r>a");
          /*  Elements elemnents1 = document.select("table").select("tr");

            for(int i=0; i<elemnents1.size()-1;i++)
            {
                DataModel dataModel = new DataModel();
                Elements tds = elemnents1.get(i).select("td");
              //  dataModel.setJobID(tds.get(0).text());
              //  dataModel.setDescription(tds.get(1).text());
              //  dataModel.setDuration(tds.get(3).text());

                dataModel.setJobID();
                dataModelList.add(dataModel);
            }*/
                    Elements lis = document.getElementsByTag("tr");
                    for (int i = 0; lis != null && i <lis.size(); i++) {
                        Element li = lis.get(i);
                        Elements spans = li.getElementsByTag("td");
                        if (spans != null && spans.size() == 6) {
                            DataModel dataModel = new DataModel();
                            dataModel.setJobID(spans.get(0).text());
                            dataModel.setDescription(spans.get(1).text());
                            dataModel.setDuration(spans.get(3).text());
                            Element lii = spans.get(1);
                            Elements spanss = lii.getElementsByTag("a");
                            dataModel.setStageUrl(spanss.attr("abs:href"));
                            dataModelList.add(dataModel);

                    }
                }
            } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
