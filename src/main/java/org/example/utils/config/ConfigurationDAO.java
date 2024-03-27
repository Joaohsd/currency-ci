package org.example.utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationDAO {
    private static ConfigurationDAO _instance;
    private Properties _properties;

    private ConfigurationDAO() {
        _properties = new Properties();
        loadProperties();
    }

    public static ConfigurationDAO getInstance() {
        if (_instance == null) {
            _instance = new ConfigurationDAO();
        }
        return _instance;
    }

    private void loadProperties() {
        try {
            // Load the properties file
            InputStream in = new FileInputStream("config_api.properties");
            _properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return _properties.getProperty(key);
    }
}
