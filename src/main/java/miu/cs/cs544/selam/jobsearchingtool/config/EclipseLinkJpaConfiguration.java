package miu.cs.cs544.selam.jobsearchingtool.config;

//import org.eclipse.persistence.config.PersistenceUnitProperties;
//import org.eclipse.persistence.logging.SessionLog;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
//import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;

//@Configuration
public class EclipseLinkJpaConfiguration {

}
//public class EclipseLinkJpaConfiguration extends JpaBaseConfiguration {
//    protected EclipseLinkJpaConfiguration(DataSource dataSource, JpaProperties properties,
//                                          ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
//        super(dataSource, properties, jtaTransactionManager);
//    }
//
//    @Override
//    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
//        return new EclipseLinkJpaVendorAdapter();
//    }
//
//    @Override
//    protected Map<String, Object> getVendorProperties() {
//        Map<String, Object> map = new HashMap<>();
//        map.put(PersistenceUnitProperties.WEAVING, false);
//        map.put(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE);
//        map.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.DROP_AND_CREATE);
//        return map;
//    }
//
////    @Bean
////    public static DataSource dataSource() {
////        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
////        dataSource.setUrl("jdbc:mysql://localhost:3306/ea");
////        dataSource.setSchema("ea");
////        dataSource.setUsername("ea");
////        dataSource.setPassword("cs544");
////        return dataSource;
////    }
//}

//        HashMap<String, Object> map = new HashMap<>();
//        map.put(PersistenceUnitProperties.WEAVING, false);
//        map.put(PersistenceUnitProperties.LOGGING_LEVEL, "fine");
//        map.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.DROP_AND_CREATE);
////        map.put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_DATABASE_GENERATION);
//        return map;
