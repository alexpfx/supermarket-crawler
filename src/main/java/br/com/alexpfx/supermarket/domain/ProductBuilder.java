package br.com.alexpfx.supermarket.domain;

import br.com.alexpfx.supermarket.domain.barcode.BarCode;
import br.com.alexpfx.supermarket.domain.barcode.Ean13;

public class ProductBuilder {
    private Integer id;
    private Manufacturer manufacturer;
    private String description;
    private String url;
    private BarCode ean;
    private Keywords keywords;
    private MeasureUnit measureUnit;

    public ProductBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public ProductBuilder manufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public ProductBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder url(String url) {
        this.url = url;
        return this;
    }

    public ProductBuilder ean(Ean13 ean) {
        this.ean = ean;
        return this;
    }

    public ProductBuilder keywords(Keywords keywords) {
        this.keywords = keywords;
        return this;
    }

    public ProductBuilder measureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
        return this;
    }

    public Product createProduct() {
        return new Product(id, manufacturer, description, url, ean, keywords, measureUnit);
    }
}