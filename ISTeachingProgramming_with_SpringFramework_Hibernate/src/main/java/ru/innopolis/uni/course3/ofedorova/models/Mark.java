package ru.innopolis.uni.course3.ofedorova.models;

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
    private int mark;
    /**
     * Ссылка на задание.
     */
    private Task task;
    /**
     * Ссылка на пользователя.
     */
    private User user;

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
     * Создает новый {@code Mark}.
     *
     * @param task значение поля "task".
     * @param user значение поля "user".
     * @param mark   значение поля "mark".
     */
    public Mark(Task task, User user, int mark) {
        super(1);
        this.mark = mark;
        this.task = task;
        this.user = user;
    }

    /**
     * Метод возвращает значение поля "mark".
     *
     * @return значение поля "mark".
     */
    public int getMark() {
        return this.mark;
    }

    /**
     * Метод устанавливает новое значение для поля "mark".
     *
     * @param mark новое значение для поля "mark".
     */
    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     * Метод возвращает значение поля "task".
     *
     * @return значение поля "task".
     */
    public Task getTask() {
        return this.task;
    }

    /**
     * Метод устанавливает новое значение поля "task".
     *
     * @param task новое значение поля "task".
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * Метод возвращает значение поля "user".
     *
     * @return значение поля "user".
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Метод устанавливает новое значение поля "user".
     *
     * @param user новое значение поля "user".
     */
    public void setUser(User user) {
        this.user = user;
    }
}
