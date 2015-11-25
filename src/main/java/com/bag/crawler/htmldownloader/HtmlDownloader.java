package com.bag.crawler.htmldownloader;

import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by johnny on 24/11/15.
 */
public interface HtmlDownloader {

     Document getHtmlDocument(String url) throws IOException;

     void setProxy();
}
