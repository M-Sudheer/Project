package demo.project.tables;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("demo.project.tables")
public class HibernateConfig 
{
	@Bean
   public DataSource getDataSource()
	{
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/project");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		
		return basicDataSource;
	}
	 
	 @Bean
	public SessionFactory getSessionfactory(DataSource dataSource)
	 {
		 LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		 factoryBuilder.addProperties(getProperties());
		 factoryBuilder.scanPackages("demo.project.tables");
		 
		 return factoryBuilder.buildSessionFactory();
	 }
	 
	 
	 public Properties getProperties()
	 {
		 Properties properties=new Properties();
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.setProperty("hibernate.show_sql", "true");
			
			return properties;
			
	 }
	 
	 
	 @Bean
	 public HibernateTransactionManager geHibernateTransactionManager(SessionFactory factory) 
	 {
		 return new HibernateTransactionManager(factory);
	 } 
}
