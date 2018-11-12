# SpringBoot 分布式事物处理 :zzz:

> 小生不足之处，还望各位前辈不吝赐教。<br>

## 项目环境

> **JDK:** 			1.8 +   
> **Spring Boot:**  	2.0.6   
> **MySQL:** 			5.7.21   
> **IDEA:** 			InteIIij IDEA   

## 项目结构
```
jta-atomikos
+
+--+ api    接口模块
|  +---+ aop               全局日志
|  +---+ config            数据源配置
|  +---+ controller        接口
|  +---+ service           业务逻辑事物控制
|  +---+ util              工具包
|
+--+ dao    持久层模块
   +---+ mybatis           mybatis-generator 自定义工具     
   +---+ one               db_one 数据源 
   |   +---+ entity        
   |   +---+ mapper        
   |   +---+ repository     
   +---+ two               db_two 数据源
       +---+ entity        
       +---+ mapper        
       +---+ repository    

```

## 项目背景

小弟本就是对分布式这块知之甚少，也是最近所做的项目遇到了这样的实际场景，不然，不知何时才能触及。

所做的是一个中英文的在线教育平台，中文版与英文版除了用户模块，其余的不论是前台展示或者在后台管理方面两者都有些许不同。因此，**数据库就一分为三**，并且**用户模块的数据库为 中文版与英文版数据库共享**。

* db_user		用户模块数据库   
* db_chn           中文版数据库
* db_en             英文版数据库

**因为这样，所以在写中文版/英文版项目接口时，就需要用到两个数据库，用户、中文版/英文版数据库。**

刚刚开始方案继承 **org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource** 实现自定义数据源路由。然后通过自定义注解来实现数据源的切换。后来发现在 **service层的 事物控制 ** 就成了问题。

后来，通过查找资料，如何解决多数据的事物问题，很多的博客也都是用 **自定义注解 + 自定义数据源路由** 来实现，对于事物也是没有解决。

慢慢的发现了 通过 **jta + atomikos** 做分布式事物，来解决事物控制的问题。但是在通过查找资料的过程中也发现有些前辈也是通过 **jta + atomikos** 来做的多数据源，他们在也文章中提出 通过这种方式对于事物处理也是没办法解决，到现在我也是很有疑问，因为我自己写的基于 **jta + atomikos** 的项目很好的解决的多数据的事物问题。

## 项目方案与数据库

#### 数据库

该项目只是对于 jta + atomikos 的测试，所以数据库，我就随意命名了两个，并且分别建立了一张表，用于测试分布式事物。分别是：

* db_one
  * t_user
* db_two
  * t_admin

#### 分包

如果不是分布式大型项目（俺也没接触过，不懂），对于多数据源项目我的建议是采用 **分包 分别指定数据源。**

上面的项目结构中有清楚的描述，dao 模块中 有两个包，one 与 two ，one 包下的 查询或更新统一使用 db_one 数据源，同理，two 下的操作统一使用 db_two 数据源。

**即我们在 dao 层区分数据源，在 service 层做所有数据源的事物控制。**

#### jta + atomikos 依赖

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jta-atomikos</artifactId>
</dependency>
```

#### 配置数据源

```java
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
```



## 项目意义

该项目是对 多数据 解决事物写的demo，如果各位前辈发现问题，还希望能够多多指点晚辈，感激不尽。

## 技术交流

:feet: <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=dcdd3d66762ab211689194912f87f082e1416c4a95313d48caf179871150fdd8">Hello World</a> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;   :point_left:



