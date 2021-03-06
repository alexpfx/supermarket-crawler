package br.com.alexpfx.supermarket.webcrawler.listeners.impl;

import br.com.alexpfx.supermarket.batch.reader.ProductList;
import br.com.alexpfx.supermarket.webcrawler.listeners.CrawlerListener;
import br.com.alexpfx.supermarket.webcrawler.to.TransferObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by alexandre on 04/01/2016.
 */
public class ProductListener implements CrawlerListener {

    @Autowired
    ProductList productList;

    @Override
    public void itemExtracted(TransferObject to) {
        productList.add(to);
    }
}
