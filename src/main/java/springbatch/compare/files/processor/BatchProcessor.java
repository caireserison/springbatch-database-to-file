package springbatch.compare.files.processor;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;
import springbatch.compare.files.model.ExampleModel;

@Configuration
public class BatchProcessor implements ItemProcessor<ExampleModel, ExampleModel> {
    @StepScope
    @Override
    public ExampleModel process(ExampleModel exampleModel) throws Exception {
        var model = exampleModel;
        if (exampleModel.getDescription().equals("Faltou")) {
            model = ExampleModel.builder()
                    .id(exampleModel.getId())
                    .name(exampleModel.getName().concat("*"))
                    .description(exampleModel.getDescription())
                    .build();
        }
        return model;
    }
}
