package com.example.t5test.web.xdm.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class dbConfigMysqlSub {        //#-->
    final String datasourceName = "datasourceMysqlSub";    //#-->
    final String prefixName = "spring.datasource.mysql.sub";   //#-->
    final String SqlSessionFactoryName = "SqlSessionFactoryMysqlSub";      //#-->
    final String SqlSessionTemplateName = "SqlSessionTemplateMysqlSub";    //#-->


    @Bean(name=datasourceName)
    @ConfigurationProperties(prefix=prefixName)
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name=SqlSessionFactoryName)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(datasourceName) DataSource datasource, ApplicationContext applicationContext) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/mapper/infra/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }


    @Bean(name=SqlSessionTemplateName)
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
