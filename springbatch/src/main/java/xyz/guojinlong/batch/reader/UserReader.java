package xyz.guojinlong.batch.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.orm.JpaNativeQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import xyz.guojinlong.batch.entity.read.User;

import javax.persistence.EntityManagerFactory;
import java.util.Collections;

@Component
public class UserReader {

    @Autowired
//    @Qualifier(value = "entityManagerFactoryPrimary")
    private EntityManagerFactory emf;

    @Bean(destroyMethod = "")
    @Qualifier("jpaPagingItemReader")
    public ItemReader<User> jpaPagingItemReader() {
        JpaPagingItemReader<User> reader = new JpaPagingItemReader<User>();
        String sqlQuery = "select * from public.user where id like :limit ";
        JpaNativeQueryProvider<User> queryProvider = new JpaNativeQueryProvider<User>();
        queryProvider.setSqlQuery(sqlQuery);
        queryProvider.setEntityClass(User.class);
        reader.setEntityManagerFactory(emf);
        reader.setPageSize(3);
        reader.setQueryProvider(queryProvider);
        reader.setParameterValues(Collections.<String, Object>singletonMap("limit", "%"));
        reader.setSaveState(true);
        return reader;
    }
}
