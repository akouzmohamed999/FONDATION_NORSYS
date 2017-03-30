package fr.norsys.fondation.connection;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.springframework.context.annotation.Bean;

//@Configuration
public class DBunitTest {

	Path resourceDirectory = Paths.get("src/main/resources");
	private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
	private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public DBunitTest() throws Exception {

		RunScript.execute(JDBC_URL, USER, PASSWORD, this.resourceDirectory + "/fondationSQL.sql",
				Charset.defaultCharset(), false);
		IDataSet dataSet = this.readDataSet();
		this.cleanlyInsert(dataSet);

	}

	private IDataSet readDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new File(this.resourceDirectory + "/dataset.xml"));
	}

	private void cleanlyInsert(IDataSet dataSet) throws Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	@Bean(name = "TestDataSource")
	private static DataSource dataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL(JDBC_URL);
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}
}
