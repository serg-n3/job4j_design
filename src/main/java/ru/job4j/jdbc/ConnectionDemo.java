package ru.job4j.jdbc;

import ru.job4j.io.Config;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /* указываем путь до файла настроек */
        Config config = new Config("C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\jdbc\\resource\\app.properties");
        /* анализируем файл*/
        config.load();
        /* регистрируем зависимость на драйвер*/
        Class.forName(config.value("driver"));
        /* подключаемся к БД*/
        try (Connection connection = DriverManager.getConnection(
                config.value("url"),
                config.value("login"),
                config.value("password"))) {
            /* получаем информацию о  БД*/
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}