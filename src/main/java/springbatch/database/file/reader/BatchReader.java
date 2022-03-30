package springbatch.database.file.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import springbatch.database.file.model.ExampleModel;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class BatchReader {
    private DataSource dataSource;

    public BatchReader(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @StepScope
    @Bean
    public JdbcCursorItemReader<ExampleModel> reader() {
        var reader = new JdbcCursorItemReader<ExampleModel>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT id, name, description FROM example");
        reader.setRowMapper(new RowMapper<ExampleModel>() {
            @Override
            public ExampleModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                return ExampleModel.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .build();
            }
        });
        return reader;
    }
}
