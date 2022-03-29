package springbatch.compare.files.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchJob {
    private JobBuilderFactory jobBuilderFactory;

    public BatchJob(JobBuilderFactory jobBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
    }

    @Bean
    public Job processJob(@Qualifier("executeStep") Step executeStep) {
        return jobBuilderFactory
                .get("processJob")
                .incrementer(new RunIdIncrementer())
                .flow(executeStep)
                .end()
                .build();
    }
}
