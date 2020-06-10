package com.javaproject.employeerequest.dao;

import com.javaproject.employeerequest.exception.DaoException;
import com.javaproject.employeerequest.profession.Profession;

import java.util.List;

public interface DictionaryDao {
    List<Profession> findProfession(String profession) throws DaoException;
}
