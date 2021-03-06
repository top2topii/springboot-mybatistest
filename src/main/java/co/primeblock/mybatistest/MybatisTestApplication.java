package co.primeblock.mybatistest;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
@SpringBootApplication
public class MybatisTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisTestApplication.class, args);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		
		Resource configLocation = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
		sessionFactory.setConfigLocation(configLocation);
		sessionFactory.setMapperLocations(res);
		
		return sessionFactory.getObject();
	}

}
