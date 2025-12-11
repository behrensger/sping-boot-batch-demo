package de.openaqua.batchdemo.main;

import de.openaqua.batchdemo.config.SpringBatchConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class BatchJob {
    SpringBatchConfig config;
    //@Autowired
    //Job firstBatchJob = SpringBatchConfig.job(JobRepository jobRepository, Step step1);



    /*
    <batch:job id="firstBatchJob">
            <batch:step id="step1">
            <batch:tasklet>
            <batch:chunk reader="itemReader" writer="itemWriter" processor="itemProcessor" commit-interval="10">
            </batch:chunk>
        </batch:tasklet>
    </batch:step>
</batch:job>

     */

}
