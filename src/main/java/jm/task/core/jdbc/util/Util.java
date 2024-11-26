package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:postgresql://localhost:5432/IlshatDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1Bobrx@7";

    private Util(){
    }
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
            throw new RuntimeException("PostgreSQL load driver error ", e);
        } catch (SQLException e) {
            throw new RuntimeException("PostgreSQL connect error ", e);
        }
    }


    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", getUrl())
                    .setProperty("hibernate.connection.username", getUser())
                    .setProperty("hibernate.connection.password", getPassword())
                    .setProperty("hibernate.dialect", getDialect())
                    .setProperty("hibernate.driver", getDriver())
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .addAnnotatedClass(User.class);

            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Создание SessionFactory не удалось:" + ex.getMessage());
            ex.printStackTrace();
            throw new ExceptionInInitializerError();

        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static final String URL = "jdbc:postgresql://localhost:5432/IlshatDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1Bobrx@7";
    private static final String DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
    private static final String DRIVER = "org.postgresql.Driver";

    public static String getUrl() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getDialect() {
        return DIALECT;
    }

    public static String getDriver() {
        return DRIVER;
    }
}
