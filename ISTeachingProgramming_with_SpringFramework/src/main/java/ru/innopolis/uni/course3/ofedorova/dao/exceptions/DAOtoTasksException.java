package ru.innopolis.uni.course3.ofedorova.dao.exceptions;

import org.springframework.dao.DataAccessException;

/**
 * Класс реализует ошибку доступа к данным модели "Task".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 28.12.2016
 */
public class DAOtoTasksException extends DataAccessException {

    /**
     * Создает новый {@code DAOtoTasksException}.
     *
     * @param msg   сообщение.
     * @param cause исключение-причина.
     */
    public DAOtoTasksException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
