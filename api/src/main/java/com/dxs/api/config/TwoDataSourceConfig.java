package com.dxs.api.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@MapperScan(basePackages={"com.dxs.dao.two.repository"}, sqlSessionFactoryRef="jtaTwoSqlSessionFactory")
public class TwoDataSourceConfig
{
    @Bean({"jtaDataSourceTwo"})
    @ConfigurationProperties(prefix="spring.jta.atomikos.datasource.jta-two")
    public DataSource jtaDataSourceChn()
    {
        return new AtomikosDataSourceBean();
    }

    @Bean({"jtaTwoSqlSessionFactory"})
    public SqlSessionFactory jtaChnSqlSessionFactory(@Qualifier("jtaDataSourceTwo") DataSource dataSource) throws Exception
    {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/dxs/dao/two/mapper/*Mapper.xml"));
        bean.setTypeAliasesPackage("com.dxs.dao.two.entity");
        return bean.getObject();
    }

    @Bean({"jtaTwoSqlSessionTemplate"})
    public SqlSessionTemplate jtaChnSqlSessionTemplate(@Qualifier("jtaTwoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}