package path.spring.batchdemo.lessons.basic.tasklet.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import path.spring.batchdemo.lessons.basic.tasklet.listener.HelloWorldJobExecutionListener;
import path.spring.batchdemo.lessons.basic.tasklet.listener.HelloWorldStepExecutionListener;

@EnableBatchProcessing
//@Configuration
public class HelloWorldTaskletConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private HelloWorldJobExecutionListener jobListener;

    @Autowired
    private HelloWorldStepExecutionListener stepExecutionListener;

    //Simple tasklet step
    @Bean
    public Step step1(){
        return steps.get("step1")
                .listener(stepExecutionListener)
                .tasklet(helloWorldTasklet())
                .build();
    }

    //Simple tasklet method #RepeatStatus
    @Bean
    public Tasklet helloWorldTasklet() {
        return (new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Hello World!");
                return RepeatStatus.FINISHED;
            }
        });
    }

    //Job
    @Bean
    public Job helloWorldJob(){
        return jobs.get("helloWorldJob")
                .listener(jobListener)
                .start(step1())
                .build();
    }

}
