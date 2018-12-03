package xyz.guojinlong.batch.configuration;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
class PersistenceContext {

//    @Autowired
//    DataSource dataSource;

//    @ConfigurationProperties(prefix = "datasource-reader")
    @Primary
    @Bean(name="r_ds")  @Qualifier("r_ds")
    public DataSource readDruidDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("postgres");
        dataSource.setPassword("postgres");
        dataSource.setCurrentSchema("public");
        return dataSource;
    }

//    @ConfigurationProperties(prefix = "datasource-writer")
//    @Bean(name="w_ds") @Qualifier("w_ds")
//    public DataSource writeDruidDataSource() {
//        return new DruidDataSource();
//    }
}