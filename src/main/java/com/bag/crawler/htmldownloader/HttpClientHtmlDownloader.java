package com.bag.crawler.htmldownloader;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by johnny on 24/11/15.
 */

@Service
public class HttpClientHtmlDownloader implements HtmlDownloader {

    @Override
    public Document getHtmlDocument(String url) throws IOException {

        URLConnection connection = new URL(url).openConnection();
        InputStream inStream = connection.getInputStream();
        String htmlText = org.apache.commons.io.IOUtils.toString(
                inStream, connection.getContentEncoding());

        return Jsoup.parse(htmlText);
    }

    @Override
    public void setProxy() {
        System.setProperty("http.proxyHost", "117.177.250.149");
        System.setProperty("http.proxyPort", "8233");
    }

    public static void main(String[] args) {
        HtmlDownloader downloader = new HttpClientHtmlDownloader();
        try {
            downloader.setProxy();
            Document htmlDocument = downloader.getHtmlDocument("http://www.pento.cn/board/28864590");

            System.out.println(htmlDocument.title());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
