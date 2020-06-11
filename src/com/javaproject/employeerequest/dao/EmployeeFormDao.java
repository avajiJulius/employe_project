package com.javaproject.employeerequest.dao;

import com.javaproject.employeerequest.domain.EmployeeForm;
import com.javaproject.employeerequest.exception.DaoException;

public interface EmployeeFormDao {
    public Long saveEmployeeForm(EmployeeForm employeeForm) throws DaoException;
}
