package fr.norsys.fondation.connection;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.charset.Charset;

import javax.sql.DataSource;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DBunitTestRun {

	private static final String PATH = "C:/Users/Mohamed/Stage/FONDATION_NORSYS/src/test/resources";
	private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
	private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	private static final String USER = "root";
	private static final String PASS = "";

	public DBunitTestRun() throws Exception {

		RunScript.execute(JDBC_URL, USER, PASS, this.PATH + "/fondationSQL.sql", Charset.forName("utf8"), false);
		IDataSet dataSet = this.readDataSet();
		this.cleanlyInsert(dataSet);

	}

	private IDataSet readDataSet() throws MalformedURLException, DataSetException {
		return new FlatXmlDataSetBuilder().build(new File(this.PATH + "/dataset.xml"));
	}

	private void cleanlyInsert(IDataSet dataSet) throws Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASS);
		databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	@Bean(name = "DataSource")
	private static DataSource dataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL(JDBC_URL);
		dataSource.setUser(USER);
		dataSource.setPassword(PASS);
		return dataSource;
	}
}
