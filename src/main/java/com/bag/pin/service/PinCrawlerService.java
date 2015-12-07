package com.bag.pin.service;

import com.bag.pin.model.Pin;
import com.bag.pin.service.handler.CrawlerPinFailureHandler;
import com.bag.pin.service.handler.CrawlerPinSuccessHandler;
import com.bag.utils.crawler.htmlParser.PinParser;
import com.bag.utils.crawler.htmldownloader.HttpClientHtmlDownloader;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinCrawlerService {

    public static final String PentoPageBaseUrl = "http://www.pento.cn/pin/";
    public static final int DEFAULT_PENTO_RANGE_CHECK_INTERVAL = 100000;


    @Autowired
    private HttpClientHtmlDownloader htmlDownloader;
    @Autowired
    private PinParser pinParser;
    @Autowired
    private CrawlerPinSuccessHandler crawlerPinSuccessHandler;
    @Autowired
    private CrawlerPinFailureHandler crawlerPinFailureHandler;

    public void craw(long minPentoId, long maxPentoId) {
      for(long i = minPentoId; i<=maxPentoId; i++) {
        crawl(String.valueOf(i));
      }
    }


    public void crawl(String pentoId)   {
        String url = getUrl(pentoId);

        try {
            Document doc = htmlDownloader.getHtmlDocument(url);
            Pin pin = pinParser.parseToPin(pentoId, doc);

            crawlerPinSuccessHandler.handle(pin);

        } catch (Exception e) {
             crawlerPinFailureHandler.handle(url, e);
        }
    }




    private String getUrl(String pentoId) {
        return PentoPageBaseUrl + pentoId;
    }


}
