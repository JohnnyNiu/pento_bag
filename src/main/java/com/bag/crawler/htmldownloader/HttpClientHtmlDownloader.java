package com.bag.crawler.htmldownloader;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

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


}
