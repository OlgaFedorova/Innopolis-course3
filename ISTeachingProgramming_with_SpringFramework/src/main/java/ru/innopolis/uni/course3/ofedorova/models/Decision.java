package ru.innopolis.uni.course3.ofedorova.models;

/**
 * Класс реализует модель "Решение пользователя".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class Decision extends Base {

    /**
     * Идентификатор задачи.
     */
    private int idTask;
    /**
     * Идентификатор пользователя.
     */
    private int idUser;
    /**
     * Текст решения.
     */
    private String decision;

    /**
     * Cоздает новый {@code Decision}.
     */
    public Decision() {
        super(1);
    }

    /**
     * Создает новый {@code Decision}.
     *
     * @param id       идентификатор решения.
     * @param idTask   идентификатор задачи.
     * @param idUser   идентификатор пользователя.
     * @param decision решение.
     */
    public Decision(int id, int idTask, int idUser, String decision) {
        super(id);
        this.idTask = idTask;
        this.idUser = idUser;
        this.decision = decision;
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
     * Метод возвращает значение поля "idUser".
     *
     * @return значение поля "idUser".
     */
    public int getIdUser() {
        return this.idUser;
    }

    /**
     * Метод возвращает значение поля "decision".
     *
     * @return значение поля "decision".
     */
    public String getDecision() {
        return this.decision;
    }

    /**
     * Метод устанавливает новое значение для поля "idTask".
     * @param idTask новое значение для поля "idTask".
     */
    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    /**
     * Метод устанавливает новое значение для поля "idUser".
     * @param idUser новое значение для поля "idUser".
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Метод устанавливает новое значение для поля "decision".
     * @param decision новое значение для поля "decision".
     */
    public void setDecision(String decision) {
        this.decision = decision;
    }
}
