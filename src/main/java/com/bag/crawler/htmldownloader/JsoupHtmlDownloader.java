package com.bag.crawler.htmldownloader;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by johnny on 24/11/15.
 */

@Service
public class JsoupHtmlDownloader implements HtmlDownloader {

    @Override
    public Document getHtmlDocument(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc;
    }

    @Override
    public void setProxy() {
        System.setProperty("http.proxyHost", "117.177.250.149");
        System.setProperty("http.proxyPort", "8233");
    }

    public static void main(String[] args) {
        HtmlDownloader downloader = new JsoupHtmlDownloader();
        try {
            downloader.setProxy();
            Document htmlDocument = downloader.getHtmlDocument("http://www.pento.cn/board/28864590");

            System.out.println(htmlDocument.title());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
