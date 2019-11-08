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
//@MapperScan(basePackages = "com.demo.dao.cluster")
public class DataSourceConfig2 {

    private static final String PATH = "com.demo.dao.cluster";
    private static final String CLUSTER_MAPPER_PATH = "classpath:mapper/cluster/*.xml";

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.druid.cluster")
    public DataSource clusterDataSource() {
        log.info("init clusterDataSource");

        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("clusterDataSource") DataSource clusterDataSource) {
        return new DataSourceTransactionManager(clusterDataSource);
    }

    @Bean(value = "clusterSqlsession")
    @Primary
    public SqlSessionFactory clusterSqlsession(@Qualifier("clusterDataSource") DataSource clusterDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(clusterDataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(PATH));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource(CLUSTER_MAPPER_PATH));
        return sqlSessionFactoryBean.getObject();
    }
}
