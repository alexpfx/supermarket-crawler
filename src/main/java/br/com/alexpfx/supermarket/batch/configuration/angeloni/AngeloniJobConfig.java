package br.com.alexpfx.supermarket.batch.configuration.angeloni;

import br.com.alexpfx.supermarket.batch.processor.AngeloniProductProcessor;
import br.com.alexpfx.supermarket.batch.reader.ProductItemReader;
import br.com.alexpfx.supermarket.batch.tasklet.StartCrawlerTasklet;
import br.com.alexpfx.supermarket.batch.writer.HibernateProductsItemWriter;
import br.com.alexpfx.supermarket.domain.Product;
import br.com.alexpfx.supermarket.webcrawler.crawler.Crawler;
import br.com.alexpfx.supermarket.webcrawler.to.TransferObject;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.AbstractJob;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alexandre on 07/02/2016.
 */
@Configuration
@EnableBatchProcessing
public class AngeloniJobConfig {

    @Autowired
    @Qualifier(value = "angeloniCrawler")
    Crawler angeloniCrawler;


    @Autowired
    private StepBuilderFactory steps;


    public Job job(JobBuilderFactory jobs) {
        Job theJob = jobs.get("crawlerJob").start(crawlerStep()).next(transformProductStep()).build();
        ((AbstractJob) theJob).setRestartable(true);
        return theJob;
    }

    @Bean
    public Tasklet crawlerTasklet() {
        return new StartCrawlerTasklet(angeloniCrawler);
    }

    @Bean
    public Step transformProductStep() {
        TaskletStep step = steps.get("transformProductStep").<TransferObject, Product>chunk(100)
                .reader(reader()).processor(processor()).writer(writer()).build();
        step.setAllowStartIfComplete(true);
        return step;
    }

    @Bean
    public ItemWriter<Product> writer() {
        return new HibernateProductsItemWriter();
    }

    @Bean
    public ItemProcessor<? super TransferObject, ? extends Product> processor() {
        return new AngeloniProductProcessor();
    }

    @Bean
    public ItemReader<TransferObject> reader() {
        return new ProductItemReader();
    }


    private Step crawlerStep() {
        TaskletStep crawlerStep = steps.get("crawlerStep").tasklet(crawlerTasklet()).build();
        crawlerStep.setAllowStartIfComplete(true);
        return crawlerStep;
    }


}