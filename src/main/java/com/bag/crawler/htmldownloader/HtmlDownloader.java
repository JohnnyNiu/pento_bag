package com.bag.crawler.htmldownloader;

import java.io.IOException;

import org.jsoup.nodes.Document;

/**
 * Created by johnny on 24/11/15.
 */
public interface HtmlDownloader {

     Document getHtmlDocument(String url) throws IOException;


}
