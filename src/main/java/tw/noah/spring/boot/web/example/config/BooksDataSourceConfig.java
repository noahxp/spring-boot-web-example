package tw.noah.spring.boot.web.example.config;

import java.util.Properties;
import javax.naming.NamingException;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * reference document : https://github.com/spring-projects/spring-data-examples/tree/master/jpa/multiple-datasources
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "booksFactoryBean" , transactionManagerRef = "booksTx",basePackages = {"tw.noah.spring.boot.web.example.dao.bookstore"})
@Log4j2
public class BooksDataSourceConfig {

  @Autowired
  private Environment env;

//  private JndiDataSourceLookup lookup = new JndiDataSourceLookup();

//  //TODO 這個寫法只支援... tomcat下的 war 部署？
//  @Bean(name = "booksDatasource")
//  @ConfigurationProperties(prefix = "books.datasource")
//  public DataSource booksDataSource() {
//    JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
//    bean.setJndiName(env.getProperty("books.datasource.jndi-name"));
////    bean.setJndiTemplate(); ???????
//    bean.setProxyInterface(DataSource.class);
//    bean.setLookupOnStartup(false);
//    try {
//      bean.afterPropertiesSet();
//    } catch (NamingException e) {
//      e.printStackTrace();
//    }
//    return (DataSource) bean.getObject();
////    return lookup.getDataSource(env.getProperty("books.datasource.jndi-name"));
////    return DataSourceBuilder.create().build();
//  }

  @Bean(name = "booksDatasource")
  @ConfigurationProperties(prefix = "books.datasource")
  public DataSource booksDataSource(){
    return DataSourceBuilder.create().build();
  }


  @Bean(name="booksTx")
  public PlatformTransactionManager booksTransactionManager(){
    return new JpaTransactionManager(booksFactoryBean().getObject());
  }

  @Bean(name="booksFactoryBean")
  public LocalContainerEntityManagerFactoryBean booksFactoryBean(){
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setGenerateDdl(false);
    jpaVendorAdapter.setShowSql(env.getProperty("books.datasource.properties.hibernate.show-sql",Boolean.class));
    jpaVendorAdapter.setGenerateDdl(env.getProperty("books.datasource.properties.hibernate.ddl-auto",Boolean.class));

    Properties prop = new Properties();
    prop.put("hibernate.dialect",env.getProperty("books.datasource.properties.hibernate.dialect"));
    prop.put("hibernate.format_sql", env.getProperty("books.datasource.properties.hibernate.format_sql",Boolean.class));
    prop.put("hibernate.use_sql_comments",env.getProperty("books.datasource.properties.hibernate.use_sql_comments",Boolean.class));

    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(booksDataSource());
    factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    factoryBean.setPackagesToScan("tw.noah.spring.boot.web.example.entity");
    factoryBean.setJpaProperties(prop);

    return factoryBean;
  }


}
