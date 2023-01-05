package com.example.t5test.web.xdm.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//#--> 내용들 필히 확인할 것
// @MapperScan(value="",...) value 안의 내용이 기존 것들과 달라야 함

@Configuration
@MapperScan(value="com.example.t5test.core.infra.code"                  //#-->
        , sqlSessionFactoryRef="sqlSessionFactoryMysqlSub")             //#-->
@EnableTransactionManagement
public class dbConfigMysqlSub {                                         //#-->

    final String datasourceName = "datasourceMysqlSub";                 //#-->
    final String prefixName = "spring.datasource.mysql.sub";            //#-->
    final String SqlSessionFactoryName = "sqlSessionFactoryMysqlSub";   //#-->
    final String SqlSessionName = "sqlSessionMysqlSub";                 //#-->

    @Bean(name=datasourceName)
    @ConfigurationProperties(prefix=prefixName)
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name=SqlSessionFactoryName)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(datasourceName) DataSource datasource
            , ApplicationContext applicationContext) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setMapperLocations(
                applicationContext.getResources("classpath:/mybatis/mapper/mysql/main/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name=SqlSessionName)
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
