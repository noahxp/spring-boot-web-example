package tw.noah.spring.boot.web.example.config;

import javax.naming.NamingException;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

//@Configuration
@Log4j2
public class JNDIConfiguration {

//  @Value("${spring.datasource.jndi-name}")
  private String booksJndiName;

//  @Bean
//  public DataSource booksJndiDataSource() throws IllegalArgumentException, NamingException {
//    log.info(booksJndiName);
//    JndiObjectFactoryBean bean = new JndiObjectFactoryBean();           // create JNDI data source
//    bean.setJndiName(booksJndiName);  // jndiDataSource is name of JNDI data source
//    bean.setProxyInterface(DataSource.class);
//    bean.setLookupOnStartup(false);
//    bean.afterPropertiesSet();
//    return (DataSource) bean.getObject();
//  }
}
