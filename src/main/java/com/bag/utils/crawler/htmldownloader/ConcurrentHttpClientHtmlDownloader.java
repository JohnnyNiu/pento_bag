package com.bag.utils.crawler.htmldownloader;


import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by johnny on 24/11/15.
 */

@Service
public class ConcurrentHttpClientHtmlDownloader implements HtmlDownloader {

    @Autowired
    PoolingHttpClientConnectionManager connectionManager;

    @Override
    public Document getHtmlDocument(String url) throws IOException {

        CloseableHttpClient client = HttpClients.custom().setConnectionManager(connectionManager).build();
        String pageContent = "---Not In Use -----";
        MultiHttpClientConnThread thread = new MultiHttpClientConnThread(client, new HttpGet(url));
        thread.start();

        return Jsoup.parse(pageContent);
    }


    public class MultiHttpClientConnThread extends Thread {
        private final CloseableHttpClient closeableHttpClient;
        private final HttpGet httpGet;

        public MultiHttpClientConnThread(CloseableHttpClient closeableHttpClient, HttpGet httpGet) {
            this.closeableHttpClient = closeableHttpClient;
            this.httpGet = httpGet;
        }

        public void run() {
            try {
                CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
                try{
                    String testResult = EntityUtils.toString(response.getEntity());

                    Document doc = Jsoup.parse(testResult);
                    System.out.println(new Date().toString() + "----" + doc.title());

                    EntityUtils.consume(response.getEntity());
                } finally {
                    response.close();
                }
            } catch (ClientProtocolException ex) {
            } catch (IOException ex) {
            }
        }
    }
}
