package br.edu.ifpr.irati.util;

import br.edu.ifpr.irati.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            Map<String, Object> settings = new HashMap<>();
            settings.put("connection.driver_class","com.mysql.cj.jdbc.Driver");
            settings.put("dialect","org.hibernate.dialect.MySQLDialect");
            settings.put("hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/agendaappjsp?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8");
            settings.put("hibernate.connection.username","root");
            settings.put("hibernate.connection.password","mysql");
            settings.put("hibernate.hbm2ddl.auto","update");
            settings.put("hibernate.current_session_context_class","thread");
            settings.put("hibernate.show_sql","true");
            settings.put("hibernate.format_sql","true");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

            MetadataSources metadataSources = new MetadataSources(serviceRegistry);
            metadataSources.addAnnotatedClass(Professor.class);
            metadataSources.addAnnotatedClass(Disciplina.class);
            metadataSources.addAnnotatedClass(Aluno.class);
            metadataSources.addAnnotatedClass(Atividade.class);
            metadataSources.addAnnotatedClass(Responsavel.class);
            metadataSources.addAnnotatedClass(Tarefa.class);

            Metadata metadata = metadataSources.buildMetadata();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }
        return sessionFactory;
    }

}
