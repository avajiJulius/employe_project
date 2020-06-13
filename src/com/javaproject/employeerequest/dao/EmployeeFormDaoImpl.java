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
import java.util.LinkedList;
import java.util.List;

public class EmployeeFormDaoImpl implements EmployeeFormDao {
    private static final String INSERT_FORM =
            "INSERT INTO employee_form(" +
                    "e_form_status, e_form_date, f_name, l_name, b_day, city_id, " +
                    "relocate_status, profession, schedule_status, experience, " +
                    "prev_employer_id, salary, university_id, course_id, about, mail)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String INSERT_EMPLOYER =
            "INSERT INTO prev_employers(" +
            "e_form_id, organization, work_start, " +
            "work_end, position, progress, quit_reason)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_FORMS = "SELECT ef.* , cs.city_name , us.university_name FROM employee_form ef " +
            "INNER JOIN cities cs ON cs.city_id = ef.city_id " +
            "INNER JOIN universities us ON us.university_id = ef.university_id " +
            "WHERE e_form_status = 0 ORDER BY e_form_date";

    //TODO refactoring - create connect method
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

//                PreviousEmployerData ped = ef.getPreviousEmployers();
//                statement.setInt(11, ef.getPreviousEmployers());

                PersonData person = ef.getPersonData();
                statement.setString(3, person.getFirstName());
                statement.setString(4, person.getLastName());
                statement.setLong(6, person.getCurrentCity().getCityId());
                statement.setString(15, person.getAbout());
                statement.setString(16, person.getEmail());

                EmployeeData employee = ef.getEmployeeData();
                statement.setDouble(10, employee.getExperience());
                statement.setDouble(12, employee.getSalary());

                EducationData education = ef.getEducation();
                statement.setLong(13, education.getUniversity().getUniversityId());
                statement.setLong(14, education.getCourse().getCourseId());


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

    public List<EmployeeForm> getEmployeeForm() throws DaoException {
        List<EmployeeForm> result = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_FORMS)) {

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                EmployeeForm ef = new EmployeeForm();
                fillEmployeeForm(rs, ef);
                fillPersonData(rs);
                fillEmployeeData(rs);
                fillEducationData(rs);
            }

            rs.close();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

    private void fillEducationData(ResultSet rs) throws SQLException {
        EducationData ed = new EducationData();
        Long universityId = rs.getLong("university_id");
        String universityName = rs.getString("university_id");
        University u = new University(universityId, universityName);
        ed.setUniversity(u);
        Course c = new Course(rs.getLong("course_id"), "");
        ed.setCourse(c);
    }

    private void fillEmployeeData(ResultSet rs) throws SQLException{
        EmployeeData ed = new EmployeeData();
        ed.setExperience(rs.getDouble("experience"));
        ed.setSalary(rs.getDouble("salary"));
        ed.setProfession(Profession.fromValue(rs.getInt("profession")));
        ed.setScheduleStatus((ScheduleStatus.fromValue(rs.getInt("schedule_status"))));
    }

    private void fillEmployeeForm(ResultSet rs, EmployeeForm ef) throws SQLException {
        ef.setEmployeeFormId(rs.getLong("e_form_id"));
        ef.setFormDate(rs.getTimestamp("e_form_date").toLocalDateTime());
        ef.setStatus(FormStatus.fromValue(rs.getInt("e_form_status")));
    }

    private void fillPersonData(ResultSet rs) throws SQLException {
        PersonData pd = new PersonData();
        pd.setFirstName(rs.getString("f_name"));
        pd.setLastName(rs.getString("l_name"));
        pd.setBirthDay(rs.getDate("b_day").toLocalDate());
        Long cityId = rs.getLong("city_id");
        String cityName = rs.getString("city_name");
        City city = new City(cityId, cityName);
        pd.setCurrentCity(city);
        pd.setRelocateStatus(RelocateStatus.fromValue(rs.getInt("relocate_status")));
        pd.setAbout(rs.getString("about"));
        pd.setEmail(rs.getString("mail"));
    }

}
