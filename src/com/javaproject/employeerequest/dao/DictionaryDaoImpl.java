package com.javaproject.employeerequest.dao;


import com.javaproject.employeerequest.config.Config;
import com.javaproject.employeerequest.domain.data.components.City;
import com.javaproject.employeerequest.exception.DaoException;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao{

    private static final String GET_CITY = "SELECT city_id, city_name FROM cities " +
            "WHERE UPPER(city_name) LIKE UPPER(?)";

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Config.getProperties(Config.DB_URL),
                Config.getProperties(Config.DB_LOGIN),
                Config.getProperties(Config.DB_PASSWORD));
        return connection;
    }



    public List<City> findCity(String cityName) throws DaoException{
        List<City> result = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_CITY)) {

            statement.setString(1, "%" + cityName + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                City city = new City(rs.getInt("city_id"),
                        rs.getString("city_name"));
                result.add(city);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

}
