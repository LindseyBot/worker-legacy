package net.lindseybot.legacy.spring;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("net.lindseybot.shared.entities")
@EnableJpaRepositories("net.lindseybot.legacy.repositories.sql")
public class MariaConfig {
}
