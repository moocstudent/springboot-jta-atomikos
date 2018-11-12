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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@MapperScan(basePackages={"com.dxs.dao.one.repository"}, sqlSessionFactoryRef="jtaOneSqlSessionFactory")
public class OneDataSourceConfig
{
    @Bean({"jtaDataSourceOne"})
    @Primary
    @ConfigurationProperties(prefix="spring.jta.atomikos.datasource.jta-one")
    public DataSource jtaDataSourceChn()
    {
        return new AtomikosDataSourceBean();
    }

    @Bean({"jtaOneSqlSessionFactory"})
    @Primary
    public SqlSessionFactory jtaChnSqlSessionFactory(@Qualifier("jtaDataSourceOne") DataSource dataSource) throws Exception
    {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/dxs/dao/one/mapper/*Mapper.xml"));
        bean.setTypeAliasesPackage("com.dxs.dao.one.entity");
        return bean.getObject();
    }
    @Bean({"jtaOneSqlSessionTemplate"})
    @Primary
    public SqlSessionTemplate jtaChnSqlSessionTemplate(@Qualifier("jtaOneSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}