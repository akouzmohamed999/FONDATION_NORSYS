package fr.norsys.fondation.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonConnexion {
	private static final Logger logger = LoggerFactory.getLogger(SingletonConnexion.class);

	@Bean(name = "dataSource")
	@Qualifier
	public static DataSource getConnexion() {
		Context ctx = null;
		DataSource dataSource = null;
		try {
			ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/Fondation_NorsysDB");

		} catch (NamingException e) {
			logger.info("l'erreur suivante est survenue lors de l'initialisation de la connexion " + e);
		}
		return dataSource;
	}
}
