//package com.demo.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * 多数据源配置类
// * <p>
// * create by liu_zhang on 2019/11/7 15:34.
// */
//@Configuration
//@Slf4j
//@MapperScan(value = "com.demo.dao.cluster", sqlSessionFactoryRef = "clusterSqlsession")
//public class ClusterDataSourceConfig {
//
//    private static final String cluster_mapper_path = "classpath:mapper/cluster/*.xml";
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.druid.cluster")
//    public DataSource clusterDataSource() {
//        log.info("init clusterDataSource");
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    @Primary
//    public DataSourceTransactionManager clusterTransactionManager() {
//        return new DataSourceTransactionManager(clusterDataSource());
//    }
//
//    @Bean(value = "clusterSqlsession")
//    @Primary
//    public SqlSessionFactory clusterSqlsession(@Qualifier("clusterDataSource") DataSource clusterDataSource) throws Exception {
//        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(clusterDataSource);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource(cluster_mapper_path));
//        return sqlSessionFactoryBean.getObject();
//    }
//}
