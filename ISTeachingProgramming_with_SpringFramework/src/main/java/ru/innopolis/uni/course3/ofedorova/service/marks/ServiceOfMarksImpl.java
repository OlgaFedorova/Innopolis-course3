package ru.innopolis.uni.course3.ofedorova.service.marks;

import org.springframework.stereotype.Component;

/**
 * Класс реализует сервис оценивания пользователей.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
@Component
public class ServiceOfMarksImpl implements ServiceOfMarks {

    /**
     * Метод возврашает оценку за решенную задачу пользователя.
     *
     * @return оценка за задачу.
     */
    @Override
    public int getMark() {
        return (int) ((Math.random() * 5) + 1);
    }
}
