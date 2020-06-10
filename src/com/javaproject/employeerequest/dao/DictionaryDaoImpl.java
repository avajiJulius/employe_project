package com.javaproject.employeerequest.dao;


import com.javaproject.employeerequest.config.Config;
import com.javaproject.employeerequest.exception.DaoException;
import com.javaproject.employeerequest.profession.Profession;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao{

    private static final String GET_PROFESSION = "SELECT profession_id, professions FROM professions " +
            "WHERE UPPER(professions) LIKE UPPER(?)";

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Config.getProperties(Config.DB_URL),
                Config.getProperties(Config.DB_LOGIN),
                Config.getProperties(Config.DB_PASSWORD));
        return connection;
    }



    public List<Profession> findProfession(String profession) throws DaoException{
        List<Profession> result = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PROFESSION)) {

            statement.setString(1, "%" + profession + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Profession p = new Profession(rs.getInt("profession_id"),
                        rs.getString("professions"));
                result.add(p);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

}
