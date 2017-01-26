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
    private String name;
    /**
     * Содержание задания.
     */
    private String content;

    /**
     * Создает новый {@code Task}.
     */
    public Task() {
        super(1);
    }

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
     * @param id      идентификатор задания.
     * @param name    название задания.
     * @param content содержание задания.
     */
    public Task(int id, String name, String content) {
        this(id, name);
        this.content = content;
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
     * Метод возвращает значение поля "name".
     *
     * @return значение поля "name".
     */
    public void setName(String name) {
        this.name = name;
    }
}
