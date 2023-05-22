//package com.example.advquerying;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableJpaRepositories(basePackages = "com.example.advquerying")
//@EnableTransactionManagement
//@PropertySource(value = "application.properties")
//public class JavaConfig {
//    @Autowired
//    private Environment environment;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
//
//        driverManagerDataSource.setUrl(environment.getProperty("spring.datasource.url"));
//
//        driverManagerDataSource.setUsername(environment.getProperty("spring.datasource.username"));
//
//        driverManagerDataSource.setPassword(environment.getProperty("spring.datasource.password"));
//
//        return driverManagerDataSource;
//    }
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setDatabase(Database.MYSQL);
//        vendorAdapter.setGenerateDdl(true);
//        vendorAdapter.setShowSql(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.demo.domain");
//        factory.setDataSource(dataSource());
//
//        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
//        jpaProperties.setProperty("hibernate.format_sql", "true");
//
//        factory.setJpaProperties(jpaProperties);
//        factory.afterPropertiesSet();
//
//        return factory.getObject();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//
//        txManager.setEntityManagerFactory(entityManagerFactory());
//
//        return txManager;
//    }
//}
