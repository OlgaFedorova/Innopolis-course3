package ru.innopolis.uni.course3.ofedorova.dao.users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoUsersException;
import ru.innopolis.uni.course3.ofedorova.common.models.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс реализует модель доступа к данным модели "User" с помощью Hibernate.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 18.01.2016
 */
public class HibernateOfDAOtoUsers implements DAOtoUsers {
    /**
     * Объект для работы с сессиями Hibernate.
     */
    private final SessionFactory factory;

    /**
     * Создает новый {@code HibernateOfDAOtoUsers}.
     */
    public HibernateOfDAOtoUsers() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Метод возвращает список рейтинга пользователей.
     *
     * @return список рейтинга пользователей.
     */
    @Override
    public Collection<Object[]> valuesRating() throws DAOtoUsersException {
        Collection<Object[]> result = Collections.EMPTY_LIST;
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            result = session.createQuery("select U.username, sum(CASE WHEN M.mark IS NULL THEN 0 ELSE M.mark END) as mark " +
                    "from Mark M right outer join M.user U group by U.username order by mark desc").list();
        } catch (Exception e) {
            throw new DAOtoUsersException(e.getMessage(), e);
        } finally {
            tx.commit();
            session.close();
        }
        return result;
    }

    /**
     * Метод возвращает пользователя по запрашиваемому имени.
     *
     * @param name имя пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getByName(String name) throws DAOtoUsersException {
        User user;
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from User where name = :name");
            query.setParameter("name", name);
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            user = null;
        } catch (Exception e) {
            throw new DAOtoUsersException(e.getMessage(), e);
        } finally {
            tx.commit();
            session.close();
        }
        return user;
    }

    /**
     * Метод возвращает пользователя по запрашиваемому идентификатору.
     *
     * @param id идентификатор пользователя.
     * @return Если пользователь найден, будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User getById(int id) throws DAOtoUsersException {
        User user = null;
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("from User where id = :id");
            query.setParameter("id", id);
            user = (User) query.getSingleResult();
        } catch (Exception e) {
            throw new DAOtoUsersException(e.getMessage(), e);
        } finally {
            tx.commit();
            session.close();
        }
        return user;
    }

    /**
     * Метод добавляет нового пользователя в БД.
     *
     * @param user данные нового пользователя.
     * @return Если пользователя удалось создать будет возвращена ссылка на него, иначе возвращается null.
     */
    @Override
    public User addNewUser(User user) throws DAOtoUsersException {
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(user);
        } catch (Exception e) {
            throw new DAOtoUsersException(e.getMessage(), e);
        } finally {
            tx.commit();
            session.close();
        }
        return this.getByName(user.getUsername());
    }

    /**
     * Метод возвращает пароль пользователя.
     *
     * @param id идентификатор пользователя.
     * @return Map, в котором ключ "password" соответствует значению пароля;
     * ключ "salt" соответствует значение соли, используемой для хеширования.
     */
    @Override
    public Map<String, String> getPasswordAndSalt(int id) throws DAOtoUsersException {
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        User user = this.getById(id);
        Map<String, String> result = new HashMap<>();
        result.put("password", user.getPassword());
        result.put("salt", user.getSalt());
        return result;
    }

    /**
     * Метод обновляет пароль у пользователя.
     *
     * @param user данные нового пользователя.
     * @return Обновленный объект пользователя.
     */
    @Override
    public User updatePassword(User user) throws DAOtoUsersException {
        final Session session = this.factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery("update User set password = :password, salt = :salt where id = :id");
            query.setParameter("password", user.getPassword());
            query.setParameter("salt", user.getSalt());
            query.setParameter("id", user.getId());
            query.executeUpdate();
        } catch (Exception e) {
            throw new DAOtoUsersException(e.getMessage(), e);
        } finally {
            tx.commit();
            session.close();
        }
        return this.getById(user.getId());
    }
}
