package ru.innopolis.uni.course3.ofedorova.dao.tasks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.models.Task;

import java.util.Collection;
import java.util.Collections;

/**
 * Класс реализует доступ к данным модели "Task" с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class HibernateOfDAOtoTasks implements DAOtoTasks {
    /**
     * Объект для работы с сессиями Hibernate.
     */
    private final SessionFactory factory;

    /**
     * Создает новый {@code HibernateOfDAOtoTasks}.
     */
    public HibernateOfDAOtoTasks() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Метод возвращает список заданий в БД.
     *
     * @param idUser идентификатор пользователя.
     * @return список заданий в БД.
     */
    @Override
    public Collection<Object[]> values(int idUser) throws DAOtoTasksException {
        Collection<Object[]> result = Collections.EMPTY_LIST;
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            result = session.createQuery(new StringBuilder().append("SELECT T.id, T.name, D.id as id_decision, D.decision, M.id as id_mark, M.mark ").
                    append("FROM Task T ").
                    append("LEFT OUTER JOIN Decision AS D ").
                    append("LEFT OUTER JOIN Mark AS M ").
                    append("ORDER BY id").toString()).list();
        } catch (Exception e) {
            throw new DAOtoTasksException(e.getMessage(), e);
        }finally {
            tx.commit();
            session.close();
        }
        return result;
    }

    /**
     * Метод возвращает задание по переданному id.
     *
     * @param id     идентификатор задания.
     * @param idUser идентификатор пользователя.
     * @return задание найденное по id.
     */
    @Override
    public Task getById(int id, int idUser) throws DAOtoTasksException {
        return null;
        /*
        return this.getJdbcTemplate().queryForObject(SQLQueries.GET_TASK_BY_ID,
                new Object[]{idUser, idUser, id},
                new RowMapper<Task>() {
                    @Override
                    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return HibernateOfDAOtoTasks.this.createTask(id, idUser, rs, true);
                    }
                });
                */
    }
}
