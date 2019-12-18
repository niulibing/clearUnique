package cn.commdata.cleardatabase;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.commdata.cleardatabase.dao")
@SpringBootApplication
public class ClearDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClearDatabaseApplication.class, args);
	}

}
