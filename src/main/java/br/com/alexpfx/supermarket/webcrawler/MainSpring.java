package br.com.alexpfx.supermarket.webcrawler;

import br.com.alexpfx.supermarket.bo.ProductBo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alexandre on 26/12/2015.
 */
public class MainSpring {


    void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring.xml");
    }

    public static void main(String[] args) {

        new MainSpring().test();
    }

    public static void mainx(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring.xml");

        ProductBo productBo = (ProductBo) context.getBean(ProductBo.class);
        context.close();
    }


}
