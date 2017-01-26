package ru.innopolis.uni.course3.ofedorova.dao.tasks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.models.Mark;
import ru.innopolis.uni.course3.ofedorova.models.Task;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        Collection<Object[]> result = new ArrayList<>();
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<Object[]> resultList = session.createQuery("from Task").list();
            for (Object task: resultList){
                Object[] objects = new Object[2];
                objects[0] = task;

                try {
                    Query query = session.createQuery("from Mark M where M.user.id = :idUser and M.task.id = :idTask");
                    query.setParameter("idUser", idUser);
                    query.setParameter("idTask", ((Task)task).getId());
                    objects[1] = query.getSingleResult();
                } catch (NoResultException e){
                    objects[1] = new Mark();
                }
                result.add(objects);
            }
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
     * @return задание найденное по id.
     */
    @Override
    public Task getById(int id) throws DAOtoTasksException {
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Task) session.get("ru.innopolis.uni.course3.ofedorova.common.controllers.models.Task", id);
        } catch (Exception e) {
            throw new DAOtoTasksException(e.getMessage(), e);
        }finally {
            tx.commit();
            session.close();
        }
    }
}
