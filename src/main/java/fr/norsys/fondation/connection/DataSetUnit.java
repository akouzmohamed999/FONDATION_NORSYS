package fr.norsys.fondation.connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

public class DataSetUnit {
	private static final Logger logger = LoggerFactory.getLogger(DataSetUnit.class);
	private String PATH;
	private String URL = null;

	protected Connection connection;
	protected IDatabaseConnection dbUnitConnection;
	protected InputStream inputStreamXML;
	protected FlatXmlDataSetBuilder xmlDSBuilder;
	protected IDataSet dataSet;

	public DataSetUnit() throws Exception {
		Class.forName("org.h2.Driver");
		try {
			this.PATH = "src/test/resources";
			this.URL = "jdbc:h2:mem:test;INIT=runscript from '" + this.PATH + "/SqlDB.sql'";
			this.connection = DriverManager.getConnection(this.URL, "", "");
		} catch (SQLException e) {
			logger.info("l'erreur suivante est survenue lors de l'initialisation de la connexion de la BDD" + e);
		}
		try {
			this.dbUnitConnection = new DatabaseConnection(this.connection);
			DatabaseConfig config = this.dbUnitConnection.getConfig();
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
			this.inputStreamXML = new FileInputStream(this.PATH + "/dataset.xml");
			this.xmlDSBuilder = new FlatXmlDataSetBuilder();
			this.xmlDSBuilder.setCaseSensitiveTableNames(false);
			this.dataSet = this.xmlDSBuilder.build(this.inputStreamXML);

			DatabaseOperation.CLEAN_INSERT.execute(this.dbUnitConnection, this.dataSet);
		} catch (Exception e) {
			logger.info("l'erreur suivante est survenue lors de l'initialisation de la connexion à la DataSet" + e);
		}

	}

	@Bean(name = "DBunit")
	public Connection getConnection() {
		return this.connection;
	}

}