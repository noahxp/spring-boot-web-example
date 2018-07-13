package tw.noah.spring.boot.web.example.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tw.noah.spring.boot.web.example.entity.Books;

/**
 * reference project : https://github.com/jahe/spring-boot-multiple-datasources
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "booksEntityManagerFactory", transactionManagerRef = "booksTransactionManager" ,basePackages = {"tw.noah.spring.boot.web.example.dao"})
public class BooksDataSourceConfig123 {

//  @Bean(name = "booksDataSource")
//  @ConfigurationProperties(prefix = "books.datasource")
//  public DataSource dataSource() {
//    return DataSourceBuilder.create().build();
//  }
//
//  @Bean(name = "booksEntityManagerFactory")
//  public LocalContainerEntityManagerFactoryBean barEntityManagerFactory( EntityManagerFactoryBuilder builder, @Qualifier("booksDataSource") DataSource dataSource) {
//    return builder
//          .dataSource(dataSource)
//          .packages(Books.class.getPackage().getName())
//          .persistenceUnit("books")
//          .build();
//  }
//
//  @Bean(name = "booksTransactionManager")
//  public PlatformTransactionManager barTransactionManager(@Qualifier("booksEntityManagerFactory") EntityManagerFactory booksEntityManagerFactory) {
//    return new JpaTransactionManager(booksEntityManagerFactory);
//  }
}
