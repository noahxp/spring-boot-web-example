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

  // TODO jndi uncompleted
  // https://stackoverflow.com/questions/32776410/configure-mutiple-datasource-in-spring-boot-with-jndi
  // https://stackoverflow.com/questions/43500462/spring-boot-jndi-application-setting
  // https://blog.csdn.net/zhangshufei8001/article/details/53333501
  // 有可能需要打包成 war ，到 tomcat 裡跑， jndi 才起的來 (embeded 的不行)
  @Bean(name = "booksDatasource")
  @ConfigurationProperties(prefix = "books.datasource")
  public DataSource booksDataSource() {
    JndiDataSourceLookup jndiLookup = new JndiDataSourceLookup();
    log.info("books.datasource.jndi-name=" + env.getProperty("books.datasource.jndi-name",String.class));
    DataSource dataSource = jndiLookup.getDataSource(env.getProperty("books.datasource.jndi-name",String.class));

    return dataSource;
  }

//  @Bean(name = "booksDatasource")
//  @ConfigurationProperties(prefix = "books.datasource")
//  public DataSource booksDataSource(){
//    return DataSourceBuilder.create().build();
//  }


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
