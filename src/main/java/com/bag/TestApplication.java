package com.bag;

import com.bag.crawler.htmlParser.PinParser;
import com.bag.crawler.htmldownloader.HtmlDownloader;
import com.bag.crawler.htmldownloader.JsoupHtmlDownloader;
import com.bag.crawler.proxy.model.Proxy;
import com.bag.crawler.proxy.service.ProxyPoolService;
import com.bag.pin.model.Pin;
import com.bag.pin.service.PinService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@ComponentScan({"com.*"})
public class TestApplication implements CommandLineRunner {
    @Autowired
    JsoupHtmlDownloader htmlDownloader;
    @Autowired
    PinService pinService;
    @Autowired
    PinParser pinParser;
    @Autowired
    ProxyPoolService proxyPoolService;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        testSuccessToGetProxies();
    }

    //successful to save a pin
    private void testSucceedToSavePin() throws IOException {
        pinService.removeAll();

        String url = "http://www.pento.cn/pin/33460966";
        String pinId = "33460966";

        Document doc = htmlDownloader.getHtmlDocument(url);
        Pin pin = pinParser.parseToPin(pinId, doc);
        System.out.println(pin);

        pinService.savePin(pin);
    }


    //failed to reach pin page
    private void testFailToReachPage() throws IOException {
        String url = "http://www.pento.cn/pin/33460966aaaa";
        Document doc = htmlDownloader.getHtmlDocument(url);
    }

    //success to get proxies
    private void testSuccessToGetProxies() throws IOException {
        List<Proxy> proxyList = proxyPoolService.findProxies();
        System.out.println(proxyList);
    }




}
