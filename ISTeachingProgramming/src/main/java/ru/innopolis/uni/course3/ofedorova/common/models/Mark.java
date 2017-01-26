package ru.innopolis.uni.course3.ofedorova.common.models;

/**
 * Класс реализует модель "Оценка пользователю".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class Mark extends Base {
    /**
     * Значение оценки.
     */
    private final int mark;

    /**
     * Создает новый {@code Mark}.
     *
     * @param id   идентификатор оценки
     * @param mark значение оценки.
     */
    public Mark(int id, int mark) {
        super(id);
        this.mark = mark;
    }

    /**
     * Создает новый {@code Mark}.
     */
    public Mark() {
        this(-1, 0);
    }


    /**
     * Метод возвращает значение поля "mark".
     *
     * @return значение поля "mark".
     */
    public int getMark() {
        return this.mark;
    }
}
