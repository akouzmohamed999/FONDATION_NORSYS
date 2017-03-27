package fr.norsys.fondation.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { "fr.norsys.fondation.repositories" })
@EnableTransactionManagement
public class PersistenceContext {
}
