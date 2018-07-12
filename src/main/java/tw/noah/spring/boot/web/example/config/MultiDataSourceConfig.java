package tw.noah.spring.boot.web.example.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MultiDataSourceConfig {

  @Value("${books.datasource.properties.hibernate.dialect}")
  private String booksDialect;

  @Bean(name = "booksDatasource")
  @ConfigurationProperties("books.datasource")
  @Primary
  public DataSource booksDataSource(){
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "consumerDatasource")
  @ConfigurationProperties("consumer.datasource")
  public DataSource consumerDataSource(){
    return DataSourceBuilder.create().build();
  }

//  @Bean(name="booksTx")
//  @Autowired
//  @Primary
//  public DataSourceTransactionManager booksTx(@Qualifier("booksDatasource") DataSource datasource) {
//    return new DataSourceTransactionManager(datasource);
//  }
//
//  @Bean(name="consumerTx")
//  @Autowired
//  public DataSourceTransactionManager consumerTx(@Qualifier ("consumerDatasource") DataSource datasource) {
//    return new DataSourceTransactionManager(datasource);
//  }

  @Bean(name = "transactionManager")
  @Primary
  public PlatformTransactionManager transactionManager() {

//    tw.noah.spring.boot.web.example.entity.books
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", booksDialect);

    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(booksDataSource());
//    emf.setJpaVendorAdapter(jpaVendorAdapter);
    emf.setPackagesToScan("tw.noah.spring.boot.web.example.entity.books");   // <- package for entities
//    emf.setPersistenceUnitName("anotherPersistenceUnit");
    emf.setJpaProperties(properties);
    emf.afterPropertiesSet();
    EntityManagerFactory factory = emf.getObject();

    return new JpaTransactionManager(factory);
  }


  @Bean(name="consumerTx")
  @Autowired
  public PlatformTransactionManager consumerTx(@Qualifier ("consumerDatasource") DataSource datasource) {
    return new DataSourceTransactionManager(datasource);
  }

}
