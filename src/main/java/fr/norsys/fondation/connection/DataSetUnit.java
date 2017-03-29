package fr.norsys.fondation.connection;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSetUnit {

	@Bean(name = "dbUnitDataSource", destroyMethod = "close")
	DataSource dataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName("org.h2.Driver");
		dataSourceConfig.setJdbcUrl("jdbc:h2:mem:datajpa;DB_CLOSE_ON_EXIT=FALSE");
		dataSourceConfig.setUsername("sa");
		dataSourceConfig.setPassword("");

		return new HikariDataSource(dataSourceConfig);
	}
}