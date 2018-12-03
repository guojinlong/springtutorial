package xyz.guojinlong.batch.writer;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import xyz.guojinlong.batch.entity.People;
import xyz.guojinlong.batch.repository.read.PeopleRepository;

@Component
public class PeopleWriter {
//    @Autowired
//    @Qualifier("w_ds")
//    public DataSource w_dataSource;

    @Autowired
    private PeopleRepository peopleRepository;

//    @Bean
//    @Qualifier("jdbcBatchItemWriter")
//    public JdbcBatchItemWriter<People> jdbcBatchItemWriter() {
//        JdbcBatchItemWriter<People> writer = new JdbcBatchItemWriter<>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//        writer.setSql("insert into people (person_id, first_name, last_name) VALUES (uuid(), :firstName, :lastName)");
//        writer.setDataSource(w_dataSource);
//        return writer;
//    }

    @Bean
    @Qualifier("repositoryItemWriter")
    public RepositoryItemWriter<People> repositoryItemWriter() {
        RepositoryItemWriter<People> peopleRepositoryItemWriter = new RepositoryItemWriter<>();
        peopleRepositoryItemWriter.setRepository(peopleRepository);
        peopleRepositoryItemWriter.setMethodName("save");
        return peopleRepositoryItemWriter;
    }
}
