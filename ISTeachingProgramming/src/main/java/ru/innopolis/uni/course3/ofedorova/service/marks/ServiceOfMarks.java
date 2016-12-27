package ru.innopolis.uni.course3.ofedorova.service.marks;

/**
 * Интерфейс реализует сервис оценивания пользователей.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public interface ServiceOfMarks {

    /**
     * Метод возврашает оценку за решенную задачу пользователя.
     *
     * @return оценка за задачу.
     */
    int getMark();
}
