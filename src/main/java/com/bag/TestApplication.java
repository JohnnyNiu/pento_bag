package com.bag;

import java.io.IOException;

import com.bag.utils.crawler.htmldownloader.ConcurrentHttpClientHtmlDownloader;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.*"})
public class TestApplication implements CommandLineRunner {
    @Autowired
    ConcurrentHttpClientHtmlDownloader htmlDownloader;
//    @Autowired
//    PinService pinService;
//    @Autowired
//    PinParser pinParser;
//    @Autowired
//    ProxyPoolService proxyPoolService;

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        testSucceedToReadPin();
    }

    //successful to save a pin
    private void testSucceedToReadPin() throws IOException {
        for(int i=0;i<1000;i++) {
            String url =  "http://www.pento.cn/pin/" + String.valueOf(33460966+i);
            Document doc = htmlDownloader.getHtmlDocument(url);
        }

    }
//
//    //successful to save a pin
//    private void testSucceedToSavePin() throws IOException {
//        pinService.removeAll();
//
//        String url = "http://www.pento.cn/pin/33460966";
//        String pinId = "33460966";
//
//        Document doc = htmlDownloader.getHtmlDocument(url);
//        Pin pin = pinParser.parseToPin(pinId, doc);
//        System.out.println(pin);
//
//        pinService.savePin(pin);
//    }

//
//    //failed to reach pin page
//    private void testFailToReachPage() throws IOException {
//        String url = "http://www.pento.cn/pin/33460966aaaa";
//        Document doc = htmlDownloader.getHtmlDocument(url);
//    }
//
//    //success to get proxies
//    private void testSuccessToGetProxies() throws IOException {
//        List<Proxy> proxyList = proxyPoolService.findProxies();
//        System.out.println(proxyList);
//    }




}
