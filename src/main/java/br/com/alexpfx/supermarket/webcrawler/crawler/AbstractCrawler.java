package br.com.alexpfx.supermarket.webcrawler.crawler;

import br.com.alexpfx.supermarket.bo.ProductBo;
import br.com.alexpfx.supermarket.webcrawler.listeners.CrawlerListener;
import br.com.alexpfx.supermarket.webcrawler.listeners.ProductExtractedListener;
import br.com.alexpfx.supermarket.domain.Product;
import com.jaunt.Document;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by alexandre on 27/12/2015.
 */
public abstract class AbstractCrawler implements Crawler {

    @Autowired
    ProductBo productBo;

    private ProductExtractedListener productExtractedListener;

    protected abstract List<String> extractSubPages(Document document);

    private String rootUrl;

    private UserAgent userAgent;

    public AbstractCrawler(UserAgent userAgent, String rootUrl) {
        this.userAgent = userAgent;
        this.rootUrl = rootUrl;
    }

    @Override
    public void crawl() {
        try {
            Document doc = userAgent.visit(rootUrl);
            List<String> links = extractSubPages(doc);

            links.forEach(s -> {
                try {
                    List<Product> products = extractProducts(userAgent.visit(s));
                    notifyListeners(products);
                } catch (ResponseException e) {
                    e.printStackTrace();
                }
            });

        } catch (ResponseException e) {
            e.printStackTrace();
        }
    }

    private void notifyListeners(List<Product> products) {
        if (productExtractedListener == null) {
            return;
        }
        products.forEach(product -> {
            productExtractedListener.productExtracted(product);
        });


    }


    @Override
    public void setListener(CrawlerListener listener) {
        this.productExtractedListener = (ProductExtractedListener) listener;
    }

    protected abstract List<Product> extractProducts(Document visit);


}