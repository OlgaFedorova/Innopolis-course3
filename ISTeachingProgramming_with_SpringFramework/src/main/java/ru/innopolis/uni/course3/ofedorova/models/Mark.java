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
     * Идентификатор задания.
     */
    private int idTask;
    /**
     * Идентификатор пользователя.
     */
    private int idUser;

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
     * @param idTask значение поля "idTask".
     * @param idUser значение поля "idUser".
     * @param mark   значение поля "mark".
     */
    public Mark(int idTask, int idUser, int mark) {
        super(1);
        this.mark = mark;
        this.idTask = idTask;
        this.idUser = idUser;
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
     * Метод возвращает значение поля "idTask".
     *
     * @return значение поля "idTask".
     */
    public int getIdTask() {
        return this.idTask;
    }

    /**
     * Метод устанавливает новое значение поля "idTask".
     *
     * @param idTask новое значение поля "idTask".
     */
    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    /**
     * Метод возвращает значение поля "idUser".
     *
     * @return значение поля "idUser".
     */
    public int getIdUser() {
        return this.idUser;
    }

    /**
     * Метод устанавливает новое значение поля "idUser".
     *
     * @param idUser новое значение поля "idUser".
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
