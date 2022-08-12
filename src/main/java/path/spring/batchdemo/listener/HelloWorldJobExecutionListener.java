package path.spring.batchdemo.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldJobExecutionListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("call before job started");
        jobExecution.getExecutionContext().put("name", "miguel");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("call after job started by:");
        System.out.println("user name: " + jobExecution.getExecutionContext().get("name"));
    }
}
