package ru.innopolis.uni.course3.ofedorova.dao.exceptions;

import org.springframework.dao.DataAccessException;

/**
 * Класс реализует ошибку доступа к данным модели "Mark".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 28.12.2016
 */
public class DAOtoMarksException extends DataAccessException {

    /**
     * Создает новый {@code DAOtoMarksException}.
     *
     * @param msg   сообщение.
     * @param cause исключение-причина.
     */
    public DAOtoMarksException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
