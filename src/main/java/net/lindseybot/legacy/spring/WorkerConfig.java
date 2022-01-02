package net.lindseybot.legacy.spring;

import net.lindseybot.legacy.spring.properties.LegacyProperties;
import net.lindseybot.shared.properties.BotProperties;
import net.lindseybot.shared.worker.DefaultWorker;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConfig extends DefaultWorker {

    @Bean
    @ConfigurationProperties(prefix = "app.bot")
    public BotProperties bot() {
        return new BotProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "app.legacy")
    public LegacyProperties api() {
        return new LegacyProperties();
    }

}
