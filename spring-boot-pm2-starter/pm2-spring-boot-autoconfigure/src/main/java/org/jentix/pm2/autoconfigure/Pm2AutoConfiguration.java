package org.jentix.pm2.autoconfigure;

import org.jentix.pm2.library.Pm2;
import org.jentix.pm2.library.Pm2Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.jentix.pm2.library.Pm2ConfigParams.*;

@Configuration
@ConditionalOnClass(Pm2.class)
@EnableConfigurationProperties(Pm2Properties.class)
public class Pm2AutoConfiguration {

    @Autowired private Pm2Properties properties;

    @Bean
    @ConditionalOnMissingBean
    public Pm2Config pm2Config() {

        String userName = properties.getUserName() == null ? System.getProperty(USER_NAME) : properties.getUserName();

        Pm2Config config = new Pm2Config();
        config.put(USER_NAME, userName);

        return config;
    }

    @Bean
    @ConditionalOnMissingBean
    public Pm2 pm2(Pm2Config config) {
        return new Pm2(config);
    }
}
