package com.example.maersk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {
    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }
}
