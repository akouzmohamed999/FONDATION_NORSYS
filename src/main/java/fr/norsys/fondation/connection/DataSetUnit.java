package fr.norsys.fondation.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSetUnit {
	private static final Logger logger = LoggerFactory.getLogger(DataSetUnit.class);
	private String PATH;
	private String URL = null;

	protected Connection connection;
	protected JdbcDataSource dataSource;
	protected IDatabaseConnection dbUnitConnection;
	protected InputStream inputStreamXML;
	protected FlatXmlDataSetBuilder xmlDSBuilder;
	protected IDataSet dataSet;

	public DataSetUnit() throws Exception {
		Class.forName("org.h2.Driver");

		try {
			this.PATH = "src/test/resources";
			this.URL = "jdbc:h2:mem:test;INIT=runscript from '" + this.PATH + "/fondationSQL.sql'";
			this.dataSource = new JdbcDataSource();
			this.dataSource.setURL(this.URL);
			this.dataSource.setUser("");
			this.dataSource.setPassword("");
			this.dbUnitConnection = new DatabaseDataSourceConnection(this.dataSource);
			DatabaseConfig config = this.dbUnitConnection.getConfig();
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
			this.inputStreamXML = new FileInputStream(this.PATH + "/dataset.xml");
			this.xmlDSBuilder = new FlatXmlDataSetBuilder();
			this.dataSet = this.xmlDSBuilder.build(this.inputStreamXML);
			DatabaseOperation.CLEAN_INSERT.execute(this.dbUnitConnection, this.dataSet);
		} catch (Exception e) {
			logger.info("l'erreur suivante est survenue lors de l'initialisation de la connexion à la DataSet" + e);
		}

	}

	@Bean(name = "DBunit")
	@Qualifier
	public DataSource getDataSource() {
		return this.dataSource;

	}

}