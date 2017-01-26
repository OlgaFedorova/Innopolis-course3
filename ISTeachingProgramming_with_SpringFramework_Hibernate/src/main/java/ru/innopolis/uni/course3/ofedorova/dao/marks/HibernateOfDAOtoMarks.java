package ru.innopolis.uni.course3.ofedorova.dao.marks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;
import ru.innopolis.uni.course3.ofedorova.common.models.Mark;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Класс реализует модель доступа к данным модели "Mark" с помощью Jdbc.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class HibernateOfDAOtoMarks implements DAOtoMarks {
    /**
     * Объект для работы с сессиями Hibernate.
     */
    private final SessionFactory factory;

    /**
     * Создает новый {@code HibernateOfDAOtoMarks}.
     */
    public HibernateOfDAOtoMarks() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Метод возвращает объект "Оценку".
     *
     * @param idUser идентификатор пользователя.
     * @param idTask идентификатор задания.
     * @return объект "Оценка".
     */
    @Override
    public Mark getMark(int idUser, int idTask) {
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from Mark M where M.user.id = :idUser and M.task.id = :idTask");
            query.setParameter("idUser", idUser);
            query.setParameter("idTask", idTask);
            return (Mark) query.getSingleResult();
        } catch (NoResultException e) {
            return new Mark();
        } catch (Exception e) {
            throw new DAOtoMarksException(e.getMessage(), e);
        } finally {
            tx.commit();
            session.close();
        }
    }

    /**
     * Метод добавляет оценку за решение пользователя в БД.
     *
     * @param mark оценка за задание.
     */
    @Override
    public void add(Mark mark) throws DAOtoMarksException {
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(mark);
        } catch (Exception e) {
            throw new DAOtoMarksException(e.getMessage(), e);
        } finally {
            tx.commit();
            session.close();
        }
    }
}
