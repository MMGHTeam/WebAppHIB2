package ir.mmghteam.springmvc.config;

import ir.mmghteam.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration //Spring config indicator
@EnableTransactionManagement //Spring transaction management indicator
public class HibernateConfig {
    @Autowired //Injecting into the class
    private ApplicationContext context;

    @Bean
    public DataSource getDataSource() // This method will establish the connection to the DB using JDBC
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
        dataSource.setUsername("mmgh");
        dataSource.setPassword("1234d");
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean getSessionFactory() // Initializing Hibernate in the application
    {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource()); //Using JDBC to enable DB connection for Beans
        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        factoryBean.setAnnotatedClasses(User.class); //Entity class User provided in the model package
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() //Transactions are interactions with the DB
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}
