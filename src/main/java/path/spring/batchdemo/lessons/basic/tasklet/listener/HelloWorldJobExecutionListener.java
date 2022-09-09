package path.spring.batchdemo.lessons.basic.tasklet.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

//Using JobExecutionListener
@Component
public class HelloWorldJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("call before job started");
        //Using JobExecutionContext
        jobExecution.getExecutionContext().put("name", "miguel");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("call after job started by:");
        //Using JobExecutionContext
        System.out.println("user name: " + jobExecution.getExecutionContext().get("name"));
    }
}
