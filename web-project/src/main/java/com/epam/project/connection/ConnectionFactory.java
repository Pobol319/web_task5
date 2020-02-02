package com.epam.project.connection;

import com.epam.project.exceptions.ConnectionFactoryException;
import com.epam.project.exceptions.PropertyReaderException;
import com.epam.project.property.PropertyReader;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DATABASE_PROPERTIES_PATH = "database.properties";
    private static final String URL_PROPERTY = "dbURL";
    private static final String USER_PROPERTY = "user";
    private static final String PASSWORD_PROPERTY = "password";

    public static ProxyConnection create() throws ConnectionFactoryException {
        Connection connection;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            PropertyReader propertyReader = new PropertyReader(DATABASE_PROPERTIES_PATH);
            String url = propertyReader.read(URL_PROPERTY);
            String user = propertyReader.read(USER_PROPERTY);
            String password = propertyReader.read(PASSWORD_PROPERTY);

            connection = DriverManager.getConnection(url, user, password);
        } catch (PropertyReaderException| SQLException e){
            throw new ConnectionFactoryException("Error with creation of connection", e);
        }
        return new ProxyConnection(connection);
    }
}
