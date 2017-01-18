package ru.innopolis.uni.course3.ofedorova.dao.exceptions;

import org.springframework.dao.DataAccessException;

/**
 * Класс реализует ошибку доступа к данным модели "User".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 28.12.2016
 */
public class DAOtoUsersException extends DataAccessException {
    /**
     * Создает новый {@code DAOtoUsersException}.
     *
     * @param msg   сообщение.
     * @param cause исключение-причина.
     */
    public DAOtoUsersException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
