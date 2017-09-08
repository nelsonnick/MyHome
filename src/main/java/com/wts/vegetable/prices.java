package com.wts.vegetable;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public class prices {


  public static void main(String[] args) throws Exception {
    String marketID = "265";
    String year = "2017";
    String month = "8";
    String day = "15";
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url("http://www.vegnet.com.cn/Price/List?marketID=" + marketID + "&year=" + year + "&month=" + month + "&day=" + day)
            .addHeader("content-type", "text/xml;charset=GBK")
            .build();
    Response response = client.newCall(request).execute();
    String html = response.body().string();
    Document doc = Jsoup.parse(html);
    System.out.println(html);
    List<Element> vegetables = doc.select("div.pri_k>p");
    for (int i=0;i<vegetables.size();i++){
      List<Element> details = vegetables.get(i).select("p>span.k_2");
      System.out.println(details.get(0).text());//name
      System.out.println(details.get(1).text());//low
      System.out.println(details.get(2).text());//high
      System.out.println(details.get(3).text());//average
    }

  }
}
