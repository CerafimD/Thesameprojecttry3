package org.example.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.example.models.Vacancy;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBorm {
    private static Connection conn = null;
    private static ConnectionSource connectionSource = null;
    private static final String URL = "jdbc:sqlite:D:\\Thesameprojecttry6\\withdate.db";

    private static Dao<VacancyEntity, String> VacancyDao = null;
    public static void connect() throws SQLException {
        connectionSource = new JdbcConnectionSource(URL);

        VacancyDao = DaoManager.createDao(connectionSource, VacancyEntity.class);

    }
    public static void createTable() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, VacancyEntity.class);
    }
    public static void saveVacancies(Vacancy vacancy) throws SQLException {
        VacancyDao.create(new VacancyEntity(vacancy.getName(),vacancy.getDescription(),vacancy.isPremium(),
                    vacancy.getEmployerName(),vacancy.getSalary(),vacancy.getAreaName(),vacancy.getPublishedAt())) ;

        //query for all - вывод всего лист плеер фоловер ентитис
        //
    }
    public static List<VacancyEntity> getVacancies() throws SQLException {
        return VacancyDao.queryForAll();
    }
    public static void close() throws Exception{
        connectionSource.close();
    }
}
