package com.bag.utils.proxy.model;

/**
 * Created by johnny on 25/11/15.
 */
public class Proxy {
    public final String url;
    public final String port;

    public Proxy(String url, String port) {
        this.url = url;
        this.port = port;
    }

    @Override
    public String toString() {
        return "Proxy{" +
                "url='" + url + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
