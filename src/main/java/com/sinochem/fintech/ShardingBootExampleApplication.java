package com.sinochem.fintech;


import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.sinochem.fintech.mapper")
@EnableSwagger2
public class ShardingBootExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingBootExampleApplication.class, args);
    }
}
