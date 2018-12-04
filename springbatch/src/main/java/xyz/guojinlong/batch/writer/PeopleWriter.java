package xyz.guojinlong.batch.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import xyz.guojinlong.batch.entity.wirte.People;
import xyz.guojinlong.batch.repository.PeopleCrudRepository;
import xyz.guojinlong.batch.repository.PeopleRepository;

@Component
@Slf4j
public class PeopleWriter {
//    @Autowired
//    @Qualifier("r_ds")
//    public DataSource w_dataSource;

    @Autowired
    private PeopleRepository peopleRepository;

//    @Autowired
//    private PeopleCrudRepository peopleCrudRepository;

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
