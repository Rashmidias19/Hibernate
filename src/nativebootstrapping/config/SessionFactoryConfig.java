package nativebootstrapping.config;

import nativebootstrapping.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig(){
    }

    public static SessionFactoryConfig getInstance(){
        return(null==factoryConfig)
                ?factoryConfig=new SessionFactoryConfig()
                :factoryConfig;
    }

    public Session getSession(){
        StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder()
                .configure()
                .build();

        Metadata metadata=new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyLegacyJpaImpl.INSTANCE)
                .build();

        SessionFactory sessionFactory=metadata.buildSessionFactory();

        return sessionFactory.openSession();
    }
}
