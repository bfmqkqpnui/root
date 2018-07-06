package persons.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Hello world!
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"persons.springboot.mapper"})
public class EmployeeProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeProviderApplication.class, args);
    }
}
