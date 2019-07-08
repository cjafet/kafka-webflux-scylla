package com.cjafet.reactive;

import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;

import java.util.Collections;
import java.util.List;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    private static final String KEYSPACE = "openfx3";
    //private static final String CPS = "docker.for.mac.localhost";
    //private static final String CPS = "scylla";
    private static final String CPS = "127.0.0.1";


    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setJmxReportingEnabled(false);
        cluster.setContactPoints(CPS);
        cluster.setPort(9042);
        cluster.setKeyspaceCreations(getKeyspaceCreations());
        cluster.setReconnectionPolicy(new ConstantReconnectionPolicy(1000));

        return cluster;
    }

    @Override public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }


    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(KEYSPACE)
                .ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication());
    }
}
