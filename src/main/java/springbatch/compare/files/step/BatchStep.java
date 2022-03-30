package springbatch.compare.files.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbatch.compare.files.model.ExampleModel;
import springbatch.compare.files.processor.BatchProcessor;

@Configuration
public class BatchStep {
    private StepBuilderFactory stepBuilderFactory;

    public BatchStep(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step executeStep(
            JdbcCursorItemReader<ExampleModel> reader,
            FlatFileItemWriter<ExampleModel> writer) {
        return stepBuilderFactory
                .get("executeStep")
                .<ExampleModel, ExampleModel>chunk(2)
                .reader(reader)
                .processor(new BatchProcessor())
                .writer(writer)
                .build();
    }
}
