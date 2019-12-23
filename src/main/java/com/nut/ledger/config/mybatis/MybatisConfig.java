package com.nut.ledger.config.mybatis;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Auther: han jianguo
 * @Date: 2019/12/20 15:53
 * @Description:
 **/
@Configuration
@PropertySource("classpath:druid.properties")
@MapperScan(basePackages = {"com.nut.ledger.db.dao"})
public class MybatisConfig {

    @Bean("myDataSource")
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource getDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("myDataSource") DataSource myDynamicDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(myDynamicDataSource);
        sqlSessionFactory.setTypeAliasesPackage("com.nut.ledger.db.pojo");
        Resource[] resources = new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/nut/ledger/db/mapper/*Mapper.xml");
        sqlSessionFactory.setMapperLocations(resources);
        return sqlSessionFactory;
    }
}
