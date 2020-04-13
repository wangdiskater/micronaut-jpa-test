package jpatest;

import io.micronaut.runtime.Micronaut;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//        SessionFactory sessionFactory = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
        Micronaut.run(Application.class);
    }
}