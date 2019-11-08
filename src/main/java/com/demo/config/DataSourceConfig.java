package com.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 多数据源配置类
 * <p>
 * create by liu_zhang on 2019/11/7 15:34.
 */
@SpringBootConfiguration
@Slf4j
//@MapperScan(basePackages = "com.demo.dao.master")
public class DataSourceConfig {

    private static final String PATH = "com.demo.dao.master";
    private static final String MASTER_MAPPER_PATH = "classpath:mapper/master/*.xml";


    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.druid.muster")
    public DataSource masterDataSource() {
        log.info("init masterDataSource");
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(value = "masterSqlsession")
    @Primary
    public SqlSessionFactory masterSqlsession(@Qualifier("masterDataSource") DataSource masterDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(masterDataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(PATH));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource(MASTER_MAPPER_PATH));
        return sqlSessionFactoryBean.getObject();
    }
}
