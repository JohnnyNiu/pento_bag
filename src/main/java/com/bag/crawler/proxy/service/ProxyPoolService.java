package com.bag.crawler.proxy.service;

import com.bag.crawler.htmlParser.ProxyPoolPageParser;
import com.bag.crawler.htmldownloader.HtmlDownloader;
import com.bag.crawler.htmldownloader.HttpClientHtmlDownloader;
import com.bag.crawler.proxy.model.Proxy;
import org.apache.http.client.HttpClient;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by johnny on 25/11/15.
 */
@Service
public class ProxyPoolService {

    @Autowired
    HttpClientHtmlDownloader htmlDownloader;

    @Autowired
    ProxyPoolPageParser proxyPoolPageParser;

    private static final String url = "http://www.freeproxylists.net/zh/?c=CN&pr=HTTP&u=80&s=u";

    public List<Proxy> findProxies() throws IOException {
        Document document = htmlDownloader.getHtmlDocument(url);

        return proxyPoolPageParser.getProxiesfrom(document);
    }
}
