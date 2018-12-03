package xyz.guojinlong.batch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.guojinlong.batch.entity.JobResult;
import xyz.guojinlong.batch.service.JobLaunchService;

@RestController
@Slf4j
@RequestMapping("/jpa")
public class JpaPagingJobLauncherController {

    @Autowired
    private JobLaunchService jobLaunchService;

    @Autowired
    private Job jobInJpaPagingWithRepositoryItemWriter;

    @GetMapping("repos")
    public JobResult launchJobInJpaPagingWithRepositoryItemWriter() {
        return jobLaunchService.launchJob(jobInJpaPagingWithRepositoryItemWriter);
    }

}
