package com.javaproject.employeerequest.dao;

import com.javaproject.employeerequest.config.Config;
import com.javaproject.employeerequest.domain.EmployeeForm;
import com.javaproject.employeerequest.domain.data.EducationData;
import com.javaproject.employeerequest.domain.data.EmployeeData;
import com.javaproject.employeerequest.domain.data.PersonData;
import com.javaproject.employeerequest.domain.data.PreviousEmployerData;
import com.javaproject.employeerequest.domain.data.components.*;
import com.javaproject.employeerequest.exception.DaoException;

import java.sql.*;
import java.time.LocalDateTime;

public class EmployeeFormDaoImpl implements EmployeeFormDao {
    private static final String INSERT_FORM =
            "INSERT INTO employee_form(" +
                    "e_form_status, e_form_date, f_name, l_name, b_day, city_id, " +
                    "relocate_status, profession, schedule_status, experience, " +
                    "salary, university_id, course_id, about, mail)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String INSERT_EMPLOYER =
            "INSERT INTO prev_employers(" +
            "e_form_id, organization, work_start, " +
            "work_end, position, progress, quit_reason)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    //TODO refactoring - cteate connect method
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Config.getProperties(Config.DB_URL),
                Config.getProperties(Config.DB_LOGIN),
                Config.getProperties(Config.DB_PASSWORD));
        return connection;
    }

    public Long saveEmployeeForm(EmployeeForm ef) throws DaoException {
        Long result = -1L;

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_FORM, new String[]{"e_form_id"})) {

            connection.setAutoCommit(false);
            try {
                statement.setInt(1, FormStatus.UNCHECKED.ordinal());
                statement.setInt(7, RelocateStatus.UNSELECTED.ordinal());
                statement.setInt(8, Profession.UNSELECTED.ordinal());
                statement.setInt(9, ScheduleStatus.UNSELECTED.ordinal());
                statement.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));
                statement.setDate(5, java.sql.Date.valueOf(ef.getPersonData().getBirthDay()));

                PersonData person = ef.getPersonData();
                statement.setString(3, person.getFirstName());
                statement.setString(4, person.getLastName());
                statement.setLong(6, person.getCurrentCity().getCityId());
                statement.setString(14, person.getAbout());
                statement.setString(15, person.getEmail());

                EmployeeData employee = ef.getEmployeeData();
                statement.setDouble(10, employee.getExperience());
                statement.setDouble(11, employee.getSalary());

                EducationData education = ef.getEducation();
                statement.setLong(12, education.getUniversity().getUniversityId());
                statement.setLong(13, education.getCourse().getCourseId());


                statement.executeUpdate();

                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next())
                    result = resultSet.getLong(1);
                resultSet.close();

                savePreviousEmployers(connection, ef, result);

                connection.commit();

            } catch (SQLException ex) {
                connection.rollback();
                throw ex;
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

    private void savePreviousEmployers(Connection connection, EmployeeForm ef, Long efId) throws SQLException{
        try (PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYER)) {
            for (PreviousEmployerData employer : ef.getPreviousEmployers()) {
                statement.setLong(1, efId);
                statement.setString(2,employer.getOrganization());
                statement.setDate(3, java.sql.Date.valueOf(employer.getWorkStart()));
                statement.setDate(4, java.sql.Date.valueOf(employer.getWorkEnd()));
                statement.setString(5, employer.getPosition());
                statement.setString(6, employer.getProgress());
                statement.setString(7, employer.getQuitReason());
            }
        }
    }

}
