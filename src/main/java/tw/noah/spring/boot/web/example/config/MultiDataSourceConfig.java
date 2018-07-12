package tw.noah.spring.boot.web.example.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MultiDataSourceConfig {

  // TODO uncomplete
  @Bean(name = "books.db")
  @ConfigurationProperties("books.datasource")
  @Primary
  public DataSource booksDataSource(){
    return DataSourceBuilder.create().build();
  }

//  @Bean(name = "consumer.db")
//  @ConfigurationProperties("consumer.datasource")
//  public DataSource consumerDataSource(){
//    return DataSourceBuilder.create().build();
//  }
}
