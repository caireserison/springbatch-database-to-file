package springbatch.database.file.writer;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import springbatch.database.file.model.ExampleModel;

@Configuration
public class BatchWriter {
    @StepScope
    @Bean
    public FlatFileItemWriter<ExampleModel> writer() {
        var writer = new FlatFileItemWriter<ExampleModel>();
        //writer.setResource(new FileSystemResource("C:\\Nova Pasta\\test.csv"));
        writer.setResource(new FileSystemResource("C:\\Nova Pasta\\test.txt"));
        var aggregator = new DelimitedLineAggregator<ExampleModel>();
        var fieldExtractor = new BeanWrapperFieldExtractor<ExampleModel>();

        fieldExtractor.setNames(new String[]{"id", "name", "description"});
        aggregator.setFieldExtractor(fieldExtractor);
        writer.setLineAggregator(aggregator);

        return writer;
    }
}
