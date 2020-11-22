package lzw.example.spring.docker.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("lzw.exapmle.spring.docker")
public class MybatisPlusConfig {

	@Bean
    public MybatisSqlInterceptor mybatisSqlInterceptor(){
        return  new MybatisSqlInterceptor();
    }
}
