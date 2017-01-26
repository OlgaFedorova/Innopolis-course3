package ru.innopolis.uni.course3.ofedorova.common.models;

/**
 * Класс реализует модель "Задание для пользователя".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 27.12.2016
 */
public class Task extends Base {
    /**
     * Название задания.
     */
    private final String name;
    /**
     * Содержание задания.
     */
    private String content;

    /**
     * Решение задачи от текущего пользователя.
     */
    private Decision decision;
    /**
     * Оценка за задачу.
     */
    private Mark mark;

    /**
     * Создает новый {@code Task}.
     *
     * @param id   идентификатор задания.
     * @param name название задания.
     */
    public Task(int id, String name) {
        super(id);
        this.name = name;
    }

    /**
     * Создает новый {@code Task}.
     *
     * @param id       идентификатор задания.
     * @param name     название задания.
     * @param decision решение задания.
     */
    public Task(int id, String name, Decision decision) {
        this(id, name);
        this.decision = decision;
    }

    /**
     * Создает новый {@code Task}.
     *
     * @param id      идентификатор задания.
     * @param name    название задания.
     * @param content содержание задания.
     */
    public Task(int id, String name, String content) {
        this(id, name);
        this.content = content;
    }

    /**
     * Создает новый {@code Task}.
     *
     * @param id       идентификатор задания.
     * @param name     название задания.
     * @param content  содержание задания.
     * @param decision решение задания.
     */
    public Task(int id, String name, String content, Decision decision) {
        this(id, name, content);
        this.decision = decision;
    }

    /**
     * Создает новый {@code Task}.
     *
     * @param id       идентификатор задания.
     * @param name     название задания.
     * @param decision решение задания.
     * @param mark     оценка за решение.
     */
    public Task(int id, String name, Decision decision, Mark mark) {
        this(id, name, decision);
        this.mark = mark;
    }

    /**
     * Создает новый {@code Task}.
     *
     * @param id       идентификатор задания.
     * @param name     название задания.
     * @param content  содержание задания.
     * @param decision решение задания.
     * @param mark     оценка за решение.
     */
    public Task(int id, String name, String content, Decision decision, Mark mark) {
        this(id, name, content, decision);
        this.mark = mark;
    }

    /**
     * Метод устанавливает новое значение для поля "content".
     *
     * @param content значение для поля "content".
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Метод возвращает значение поля "content".
     *
     * @return значение поля "content".
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Метод возвращает значение поля "name".
     *
     * @return значение поля "name".
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод возвращает значение поля "decision".
     *
     * @return значение поля "decision".
     */
    public Decision getDecision() {
        return this.decision;
    }

    /**
     * Метод возвращает значение поля "mark".
     *
     * @return значение поля "mark".
     */
    public Mark getMark() {
        return this.mark;
    }
}
