package com.example.hsqldb_in_server_mode.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl;

import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class DbConfig {

    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {
        startHsqldbServer();
        return DataSourceBuilder.create().build();
    }

    /**
     * Start hsqldb in server mode. We can do the same from the command line:
     * $ java -cp $MAVEN_REPO_HOME/org/hsqldb/hsqldb/2.5.2/hsqldb-2.5.2.jar org.hsqldb.server.Server --database.0 mem:rewards --dbname.0 rewards
     * Hsqldb server will be running in a different process though.
     */
    private void startHsqldbServer() {
        try {
            HsqlProperties hsqlProperties = new HsqlProperties();
            hsqlProperties.setProperty("server.database.0", "mem:rewards");
            hsqlProperties.setProperty("server.dbname.0", "rewards");
            Server server = new Server();
            server.setProperties(hsqlProperties);
            server.setLogWriter(new PrintWriter(System.out));
            server.setErrWriter(new PrintWriter(System.out));
            server.start();
        } catch (IOException | ServerAcl.AclFormatException e) {
            throw new RuntimeException(e);
        }

    }
}
