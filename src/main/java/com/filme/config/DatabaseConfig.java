package com.filme.config;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

import com.filme.model.Filme;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DatabaseConfig {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties propriedates = new Properties();

                propriedates.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                propriedates.put(Environment.URL, "jdbc:mysql://localhost:3306/filmes?useSSL=false");
                propriedates.put(Environment.USER, "root");
                propriedates.put(Environment.PASS, "1190");
                propriedates.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");


                propriedates.put(Environment.SHOW_SQL, "true");

                propriedates.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                propriedates.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(propriedates);

                configuration.addAnnotatedClass(Filme.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
