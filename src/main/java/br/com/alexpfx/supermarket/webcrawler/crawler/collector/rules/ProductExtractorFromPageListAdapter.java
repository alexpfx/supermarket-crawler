package br.com.alexpfx.supermarket.webcrawler.crawler.collector.rules;

import br.com.alexpfx.supermarket.webcrawler.crawler.apibridge.CrawlerAPI;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by alexandre on 26/01/2016.
 */
public class ProductExtractorFromPageListAdapter extends ProductExtractorFromPageList {
    public ProductExtractorFromPageListAdapter(
            CrawlerAPI crawlerAPI) {
        super(crawlerAPI);
    }

    @Override
    protected String extractQuantidade(Element p) {
        return null;
    }

    @Override
    protected String extractPrecoOriginal(Element p) {
        return null;
    }

    @Override
    protected String extractPrecoFinal(Element p) {
        return null;
    }

    @Override
    protected String extractUnidadeMedida(Element p) {
        return null;
    }

    @Override
    protected String extractDescricao(Element p) {
        return null;
    }

    @Override
    protected String extractCodigo(Element p) {
        return null;
    }

    @Override
    protected String extractUrl(Element p) {
        return null;
    }

    @Override
    protected String extractFabricante(Element p) {
        return null;
    }

    @Override
    public Elements extractItemList(Document doc) {
        return null;
    }
}
