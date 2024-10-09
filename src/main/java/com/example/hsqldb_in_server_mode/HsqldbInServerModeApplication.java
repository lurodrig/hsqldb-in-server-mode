package com.example.hsqldb_in_server_mode;

import com.example.hsqldb_in_server_mode.config.DbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DbConfig.class)
public class HsqldbInServerModeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HsqldbInServerModeApplication.class, args);
	}
}
