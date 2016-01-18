package br.com.alexpfx.supermarket.webcrawler.crawler;

import com.jaunt.UserAgent;

import java.util.List;

/**
 * Created by alexandre on 17/01/2016.
 */
public interface Collector<T> {
    void setCollectorRule(CollectorRule<T> collectorRule);

    List<T> collect(List<String> urls);


    void setUserAgent(UserAgent userAgent);


}
