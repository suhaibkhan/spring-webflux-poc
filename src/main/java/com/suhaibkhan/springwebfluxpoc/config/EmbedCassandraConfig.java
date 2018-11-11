package com.suhaibkhan.springwebfluxpoc.config;

import com.datastax.driver.core.Session;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class EmbedCassandraConfig {

    private static Logger logger = LoggerFactory.getLogger(EmbedCassandraConfig.class);

    @Autowired
    private CassandraProperties cassandraProperties;

    @PostConstruct
    public void startEmbeddedCassandra() throws Exception{
        logger.info("Starting Embedded Cassandra");
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        createKeySpace();
    }

    private void createKeySpace() {
        logger.info("Creating Cassandra keyspace {}.", cassandraProperties.getKeyspaceName());
        Session cassSession = EmbeddedCassandraServerHelper.getSession();
        cassSession.execute("CREATE KEYSPACE IF NOT EXISTS " +
                cassandraProperties.getKeyspaceName() + "\n" +
                "WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};");
    }

    @PreDestroy
    public void stopEmbeddedCassandra() {
        logger.info("Stopping Embedded Cassandra");
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
    }
}
