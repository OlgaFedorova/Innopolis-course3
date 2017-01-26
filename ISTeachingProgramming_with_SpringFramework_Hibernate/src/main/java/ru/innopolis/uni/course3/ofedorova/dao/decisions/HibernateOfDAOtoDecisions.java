package ru.innopolis.uni.course3.ofedorova.dao.decisions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException;
import ru.innopolis.uni.course3.ofedorova.models.Decision;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Класс реализует модель доступа к данным модели "Decision"  с помощью JDBC.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class HibernateOfDAOtoDecisions implements DAOtoDecisions {
    /**
     * Объект для работы с сессиями Hibernate.
     */
    private final SessionFactory factory;

    /**
     * Создает новый {@code HibernateOfDAOtoDecisions}.
     */
    public HibernateOfDAOtoDecisions() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Метод возвращает объект "Решение".
     *
     * @param idUser идентификатор пользователя.
     * @param idTask идентификатор задания.
     * @return объект "Решение".
     */
    @Override
    public Decision getDecision(int idUser, int idTask) {
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from Decision D where D.user.id = :idUser and D.task.id = :idTask");
            query.setParameter("idUser", idUser);
            query.setParameter("idTask", idTask);
            return (Decision) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DAOtoDecisionsException(e.getMessage(), e);
        } finally {
            tx.commit();
            session.close();
        }
    }

    /**
     * Метод добавляет решение пользователя в систему.
     *
     * @param decision решениe пользователя.
     */
    @Override
    public void add(Decision decision) {
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(decision);
        } catch (Exception e) {
            throw new DAOtoDecisionsException(e.getMessage(), e);
        } finally {
            tx.commit();
            session.close();
        }
    }
}
