package path.spring.batchdemo.lessons.reader.csv.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import path.spring.batchdemo.lessons.reader.csv.readers.CSVItemReader;

@EnableBatchProcessing
//@Configuration
public class CSVReaderChunkConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public CSVItemReader reader() {
        return new CSVItemReader();
    }

    //Simple tasklet step
    @Bean
    public Step step1(){
        return steps.get("step1")
                .<Integer, Integer>chunk(3)
                .reader(reader())
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
