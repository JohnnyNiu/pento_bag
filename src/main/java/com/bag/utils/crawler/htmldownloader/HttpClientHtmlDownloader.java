package com.bag.utils.crawler.htmldownloader;


import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by johnny on 24/11/15.
 */

@Service
public class HttpClientHtmlDownloader implements HtmlDownloader {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientHtmlDownloader.class);

    public static HttpClient DEFAULT_HTTP_CLIENT = getMultiThreadHttpClient();
    private static int timeout = 5000;

    @Override
    public Document getHtmlDocument(String url) throws RuntimeException, IOException {

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = DEFAULT_HTTP_CLIENT.execute(httpGet);
        StringBuffer htmlBuf = new StringBuffer();

        if(response.getStatusLine().getStatusCode() !=200) {
              logger.error("Failed To download page from downloader: {}", url);
        }

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = rd.readLine()) != null) {
            htmlBuf.append(line);
        }
        String htmlText = htmlBuf.toString();
        if(StringUtils.isEmpty(htmlText)) {
            logger.error("Failed To download page from downloader: {}", url);
        }

//        httpGet.releaseConnection();
        return Jsoup.parse(htmlText);
    }

    private static HttpClient getHttpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout).build();


        HttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .disableCookieManagement().build();

        return client;
    }

    private static HttpClient getMultiThreadHttpClient() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
// Increase max total connection to 200
        cm.setMaxTotal(200);
// Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);
// Increase max connections for localhost:80 to 50
//        HttpHost localhost = new HttpHost("locahost", 80);
//        cm.setMaxPerRoute(new HttpRoute(localhost), 50);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout).build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig)
                .disableCookieManagement()
                .build();

        return httpClient;
    }

}
