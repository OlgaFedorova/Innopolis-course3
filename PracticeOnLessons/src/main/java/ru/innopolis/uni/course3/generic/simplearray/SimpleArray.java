package ru.innopolis.uni.course3.generic.simplearray;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

/**
 * Class implement simple array.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 21.12.2016
 * @param <T> the class of the objects in the array.
 */
public class SimpleArray<T> {
    /**
     * Object for storage of data.
     */
    private Object[] container;
    /**
     * Current position in container.
     */
    private int position;
    /**
     * Capacity of container.
     */
    private final int capacity;

    /**
     * Allocates a new {@code SimpleArray}.
     *
     * @param capacity value of field "capacity".
     */
    public SimpleArray(int capacity) {
        this.capacity = capacity;
        this.container = new Object[capacity];
    }

    /**
     * Method adds new element in container.
     *
     * @param element value for adding in container.
     * @return if element adding return true, else return false.
     */
    public boolean add(T element) {
        if (this.position >= this.container.length) {
            this.enlargeCapacity();
        }
        this.container[this.position++] = element;
        return true;
    }

    /**
     * Method updates element in container by index.
     *
     * @param index   value of index, when states element in container.
     * @param element new value for updating.
     * @return if element updates return true, else return false.
     */
    public boolean update(int index, T element) {
        boolean isUpdating = false;
        if (index >= 0 && index < this.container.length) {
            this.container[index] = element;
            isUpdating = true;
        }
        return isUpdating;
    }

    /**
     * Method deletes element from container by value.
     *
     * @param element value for deleting.
     * @return if element deletes return true, else return false.
     */
    public boolean delete(T element) {
        boolean isDelete = false;
        int index = this.getIndex(element);
        if (index != -1) {
            this.deleteElement(index);
            isDelete = true;
        }
        return isDelete;
    }

    /**
     * Method deletes element from container by index.
     *
     * @param index index of deleting element.
     * @return value of deleting element/
     */
    public T delete(int index) {
        T delete = null;
        if (index >= 0 && index < this.container.length) {
            delete = (T) this.container[index];
            this.deleteElement(index);
        }
        return delete;
    }

    /**
     * Method get element by index.
     *
     * @param index index of element.
     * @return element by index.
     */
    public T get(int index) {
        T result = null;
        if (index >= 0 && index < this.container.length) {
            result = (T) this.container[index];
        }
        return result;
    }


    /**
     * Method create new instance by reflection.
     *
     * @return new instance of type generic.
     */
    public T getNewInstance() {
        T value = null;
        Class<T> tClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            value = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * Method returns copy of container.
     *
     * @return copy of container.
     */
    public Object[] toArray() {
        Object[] tmp = new Object[this.container.length];
        System.arraycopy(this.container, 0, tmp, 0, tmp.length);
        return tmp;
    }

    /**
     * Method enlarges capacity of container.
     */
    private void enlargeCapacity() {
        Object[] tmp = this.container;
        this.container = new Object[this.container.length + this.capacity];
        System.arraycopy(tmp, 0, this.container, 0, tmp.length);
    }

    /**
     * Method return index of element.
     *
     * @param element value for finding.
     * @return if element finding in container returns its index, else return -1.
     */
    private int getIndex(T element) {
        int index = Arrays.binarySearch(this.container, element);
        if (!(index >= 0 && index < this.container.length)) {
            index = -1;
        }
        return index;
    }

    /**
     * Private logic for deleting element from container by index.
     * @param index index of deleting element.
     */
    private void deleteElement(int index) {
        Object[] first = new Object[index];
        System.arraycopy(this.container, 0, first, 0, index);

        Object[] second = new Object[this.container.length - index - 1];
        System.arraycopy(this.container, index + 1, second, 0, second.length);

        this.container = new Object[this.container.length];
        System.arraycopy(first, 0, this.container, 0, first.length);
        System.arraycopy(second, 0, this.container, index, second.length);

        this.position--;
    }

}
