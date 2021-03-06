package br.com.alexpfx.supermarket.webcrawler.crawler.collector.rules;

import br.com.alexpfx.supermarket.webcrawler.crawler.apibridge.CrawlerAPI;
import com.google.common.base.Preconditions;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandre on 25/01/2016.
 */
public class RibeiraoVisitorRule extends AbstractExtractionRules<String, CrawlerAPI<Document>> {
    private static final String BASE_URI = "https://www.mercadoribeirao.com.br/";

    public RibeiraoVisitorRule(CrawlerAPI<Document> parserAPI) {
        super(parserAPI);
    }

    @Override
    public List extract(String htmlCode) {
        Preconditions.checkNotNull(getCrawlerAPI());

        List<String> list = new ArrayList<>();
        Document doc = getCrawlerAPI().parse(htmlCode);
        if (doc.baseUri().isEmpty()) {
            doc.setBaseUri(BASE_URI);
        }

        Elements submenu = doc.select("a.new_sub_menu");
        submenu.forEach(element1 -> {
            String href = element1.attr("abs:href");
            list.add(href.concat("&pageNum=VER-TUDO"));
        });
        return list;
    }
}
