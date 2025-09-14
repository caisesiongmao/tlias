package com.tlias;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tlias.mapper")
public class TliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasApplication.class, args);
    }

}
