package xyz.guojinlong.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.guojinlong.batch.listener.JpaPagingBatchJobListener;

@Configuration
public class JpaPagingBatchJob {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

//    @Autowired
//    private Step stepInJpaPagingWithJdbcBatchItemWriter;

    @Autowired
    private Step stepInJpaPagingWithRepositoryItemWriter;

//    @Bean
//    public Job jobInJpaPagingWithJdbcBatchItemWriter(JpaPagingBatchJobListener listener) {
//        return jobBuilderFactory
//                .get("jobInJpaPagingWithJdbcBatchItemWriter")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(stepInJpaPagingWithJdbcBatchItemWriter)
//                .end()
//                .build();
//    }

    @Bean
    public Job jobInJpaPagingWithRepositoryItemWriter(JpaPagingBatchJobListener listener) {
        return jobBuilderFactory
                .get("jobInJpaPagingWithRepositoryItemWriter")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(stepInJpaPagingWithRepositoryItemWriter)
                .end()
                .build();
    }
}
