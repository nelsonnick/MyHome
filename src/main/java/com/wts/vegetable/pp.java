package com.wts.vegetable;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class pp {
  public static void main(String[] args)  throws Exception{
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url("http://119.163.120.130:88/allow/allow_1/Default.aspx?d=10016&m=1")
            .addHeader("content-type", "text/xml;charset=GBK")
            .build();
    Response response = client.newCall(request).execute();
    String html = response.body().string();
    System.out.println(html);
  }
}
