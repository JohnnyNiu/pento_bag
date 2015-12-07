package com.bag.utils.proxy.service;

import com.bag.utils.proxy.model.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ProxyService {


    private static final String url = "http://www.freeproxylists.net/zh/?c=CN&pt=&pr=HTTP&a%5B%5D=0&a%5B%5D=1&a%5B%5D=2&u=90";

    private static final Logger logger = LoggerFactory.getLogger(ProxyService.class);

    public static List<Proxy> findProxies() {
        List<Proxy> result = new ArrayList<>();
        result.add(new Proxy("117.177.243.42", "8085"));
        result.add(new Proxy("117.177.250.154", "8081"));
        result.add(new Proxy("117.177.250.147", "8080"));
        result.add(new Proxy("117.177.250.148", "82"));
        result.add(new Proxy("117.177.250.151", "8080"));

        return result;
    }

    public static void setRandomProxy() {
        int i = findProxies().size();
        double random = Math.floor((Math.random() * 100) % i);
        Proxy randomProxy = findProxies().get((int) random);
        setProxy(randomProxy.url, randomProxy.port);
    }


    public static void setProxy(String url, String port) {
        System.setProperty("http.proxyHost", url);
        System.setProperty("http.proxyPort", port);
        logger.info("Setting System Proxy To :{}:{}" , url, port);
    }

    public static void resetProxy() {
        System.clearProperty("http.proxyHost");
        System.clearProperty("http.proxyPort");
        logger.info("Resetting System Proxy");
    }

}
