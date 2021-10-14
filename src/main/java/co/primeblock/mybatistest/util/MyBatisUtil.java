package co.primeblock.mybatistest.util;

import java.io.IOException;
import java.io.InputStream;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;
 
@Component
public class MyBatisUtil {
    
    private SqlSessionFactory factory;
    
    // 설정 파일에 대한 로딩 필요
    public MyBatisUtil() {
        try (InputStream input = Resources.getResourceAsStream("mybatis-config.xml")) {
            factory = new SqlSessionFactoryBuilder().build(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public SqlSession getSession() {
        // boolean autoCommit
        return factory.openSession(true);
    }
}