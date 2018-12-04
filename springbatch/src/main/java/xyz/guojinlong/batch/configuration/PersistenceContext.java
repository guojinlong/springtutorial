package xyz.guojinlong.batch.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.postgresql.ds.PGConnectionPoolDataSource;
import org.postgresql.ds.PGPooledConnection;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;

//@Configuration
class PersistenceContext {

    @Autowired
    DataSource dataSource;
//
//    @ConfigurationProperties(prefix = "datasource-reader")
    @Primary
    @Bean(name="r_ds")  @Qualifier("r_ds")
    public DataSource readDruidDataSource() {
//        PGConnectionPoolDataSource dataSource = new PGConnectionPoolDataSource();
//        DruidDataSource dataSource = new DruidDataSource();
//        PGSimpleDataSource dataSource = new PGSimpleDataSource();
//        dataSource.setServerName("localhost");
//        dataSource.setDatabaseName("postgres");
//        dataSource.setUser("postgres");
//        dataSource.setPassword("postgres");
//        dataSource.setCurrentSchema("public");
        return dataSource;
    }

//    @ConfigurationProperties(prefix = "datasource-writer")
//    @Bean(name="w_ds") @Qualifier("w_ds")
//    public DataSource writeDruidDataSource() {
//        PGSimpleDataSource dataSource = new PGSimpleDataSource();
//        dataSource.setServerName("localhost");
//        dataSource.setDatabaseName("postgres");
//        dataSource.setUser("postgres");
//        dataSource.setPassword("postgres");
//        dataSource.setCurrentSchema("public");
//        return dataSource;
//    }
}