package com.bag.crawler.htmlParser;

import com.bag.crawler.proxy.model.Proxy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by johnny on 25/11/15.
 */
@Component
public class ProxyPoolPageParser {

    public List<Proxy> getProxiesfrom(Document document) {
        List<Element> ipElements = document.select(".DataGrid tr");

        //todo: continue from proxies
        return null;
    }

}
