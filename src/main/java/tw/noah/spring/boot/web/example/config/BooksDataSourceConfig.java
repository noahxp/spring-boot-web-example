package tw.noah.spring.boot.web.example.config;

import java.util.Properties;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.StringUtils;

/**
 * reference document : https://github.com/spring-projects/spring-data-examples/tree/master/jpa/multiple-datasources
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "booksFactoryBean" , transactionManagerRef = "booksTx",basePackages = {"tw.noah.spring.boot.web.example.dao.bookstore"})
@Log4j2
public class BooksDataSourceConfig {

  @Autowired
  private Environment env;

  // 打包後，用 tomcat 起 Application 才能用 JNDI ，default Spring Application 只能用 spring data 預設模式連結，https://blog.csdn.net/zhangshufei8001/article/details/53333501
  @Bean(name = "booksDatasource")
  @ConfigurationProperties(prefix = "books.datasource")
  public DataSource dataSource() {

    DataSource dataSource = null;

    String jndiName = env.getProperty("books.datasource.jndi-name",String.class);
    if (StringUtils.isEmpty(jndiName)){ // using default mode
      dataSource = DataSourceBuilder.create().build();
    }else{ // jndi mode
      dataSource = new JndiDataSourceLookup().getDataSource(jndiName);
    }

    return dataSource;
  }


  @Bean(name="booksTx")
  public PlatformTransactionManager transactionManager(@Qualifier("booksFactoryBean") LocalContainerEntityManagerFactoryBean factoryBean){
    return new JpaTransactionManager(factoryBean.getObject());
  }


  @Bean(name="booksFactoryBean")
  public LocalContainerEntityManagerFactoryBean factoryBean(@Qualifier("booksDatasource") DataSource dataSource){
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setGenerateDdl(false);
    jpaVendorAdapter.setShowSql(env.getProperty("books.datasource.properties.hibernate.show-sql",Boolean.class));
    jpaVendorAdapter.setGenerateDdl(env.getProperty("books.datasource.properties.hibernate.ddl-auto",Boolean.class));

    Properties prop = new Properties();
    prop.put("hibernate.dialect",env.getProperty("books.datasource.properties.hibernate.dialect"));
    prop.put("hibernate.format_sql", env.getProperty("books.datasource.properties.hibernate.format_sql",Boolean.class));
    prop.put("hibernate.use_sql_comments",env.getProperty("books.datasource.properties.hibernate.use_sql_comments",Boolean.class));

    LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    factoryBean.setPackagesToScan("tw.noah.spring.boot.web.example.entity");
    factoryBean.setJpaProperties(prop);

    return factoryBean;
  }


}
