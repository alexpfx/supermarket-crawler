package br.com.alexpfx.supermarket.webcrawler.crawler.api;

import br.com.alexpfx.supermarket.webcrawler.crawler.api.parse.HtmlUnitParserAPI;
import br.com.alexpfx.supermarket.webcrawler.crawler.api.parse.ParserAPI;
import br.com.alexpfx.supermarket.webcrawler.crawler.api.visitor.HtmlUnitVisitorAPI;
import br.com.alexpfx.supermarket.webcrawler.crawler.api.visitor.VisitorAPI;

/**
 * Created by alexandre on 30/01/2016.
 */
public class HtmlUnitCrawlerAPI implements CrawlerAPI {
    @Override
    public VisitorAPI getVisitorApi() {
        return new HtmlUnitVisitorAPI();
    }

    @Override
    public ParserAPI getDocumentParseApi() {
        return new HtmlUnitParserAPI();
    }
}
