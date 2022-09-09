# SpringBatch
Spring Batch Project to Demos



##Spring Batch Tables
batch_job_instance : saves a record any time a job instance is created

batch_job_execution : saves a record any time a job is executed

batch_job_parameters: saves a record any time that parameters are pass into a job execution


##JobParameters:
We can pass parameters to a job and use it for our logic. 
Any time the job parameters change spring batch create a new job instance 