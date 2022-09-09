package path.spring.batchdemo.lessons.basic.chunk.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import path.spring.batchdemo.lessons.basic.chunk.readers.ItemReader;
import path.spring.batchdemo.lessons.basic.chunk.processors.ItemProcessor;
import path.spring.batchdemo.lessons.basic.chunk.writers.ItemWriter;

@EnableBatchProcessing
//@Configuration
public class SimpleChunkConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private ItemProcessor processor;

    @Bean
    public ItemReader reader() {
        return new ItemReader();
    }

    @Bean
    public ItemProcessor processor() {
        return new ItemProcessor();
    }

    @Bean
    public ItemWriter writer() {
        return new ItemWriter();
    }

    //Simple tasklet step
    @Bean
    public Step step1(){
        return steps.get("step1")
                .<Integer, Integer>chunk(3)
                .reader(reader())
                .processor(processor)
                .writer(writer())
                .build();
    }

    //Job
    @Bean
    public Job helloWorldJob(){
        return jobs.get("helloWorldJob")
                .start(step1())
                .build();
    }

}
