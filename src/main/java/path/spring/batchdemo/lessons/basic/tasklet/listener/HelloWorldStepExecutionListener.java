package path.spring.batchdemo.lessons.basic.tasklet.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

// StepExecutionListener
@Component
public class HelloWorldStepExecutionListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("before Step Execution: " + stepExecution.getJobExecution().getExecutionContext());
        System.out.println("inside step: " + stepExecution.getJobExecution().getJobParameters());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("after Step Execution: " + stepExecution.getJobExecution().getExecutionContext());
        return null;
    }

}
