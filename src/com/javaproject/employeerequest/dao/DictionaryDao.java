package com.javaproject.employeerequest.dao;

import com.javaproject.employeerequest.domain.data.components.City;
import com.javaproject.employeerequest.exception.DaoException;

import java.util.List;

public interface DictionaryDao {
    List<City> findCity(String city) throws DaoException;
}
