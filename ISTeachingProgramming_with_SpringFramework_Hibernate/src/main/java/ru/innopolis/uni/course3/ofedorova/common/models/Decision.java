package ru.innopolis.uni.course3.ofedorova.common.models;

/**
 * Класс реализует модель "Решение пользователя".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class Decision extends Base {

    /**
     * Ссылка на задачу.
     */
    private Task task;
    /**
     * Ссылка на пользователя.
     */
    private User user;
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
     * @param task     идентификатор задачи.
     * @param user     идентификатор пользователя.
     * @param decision решение.
     */
    public Decision(int id, Task task, User user, String decision) {
        super(id);
        this.task = task;
        this.user = user;
        this.decision = decision;
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
     * Метод возвращает значение поля "user".
     *
     * @return значение поля "user".
     */
    public User getUser() {
        return this.user;
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
     * Метод устанавливает новое значение для поля "task".
     *
     * @param task новое значение для поля "task".
     */
    public void setTask(Task task) {
        this.task = task;
    }

    /**
     * Метод устанавливает новое значение для поля "user".
     *
     * @param user новое значение для поля "user".
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Метод устанавливает новое значение для поля "decision".
     *
     * @param decision новое значение для поля "decision".
     */
    public void setDecision(String decision) {
        this.decision = decision;
    }
}
