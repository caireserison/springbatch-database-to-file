package springbatch.database.file.model;

import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class ExampleModel {
    private Integer id;
    private String name;
    private String description;
}
