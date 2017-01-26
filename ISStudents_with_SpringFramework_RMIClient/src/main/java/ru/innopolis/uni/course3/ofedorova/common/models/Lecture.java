package ru.innopolis.uni.course3.ofedorova.common.models;

import java.io.Serializable;

/**
 * Created by Olga on 22.12.2016.
 */
public class Lecture extends Base  implements Serializable {

    static final long SerialVersionUID = 1L;

    private String subject;
    private int hoursOfTheory;
    private int hoursOfPractice;

    public Lecture() {
        super(1);
    }

    public Lecture(int id, String subject, int hoursOfTheory, int hoursOfPractice) {
        super(id);
        this.subject = subject;
        this.hoursOfTheory = hoursOfTheory;
        this.hoursOfPractice = hoursOfPractice;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getHoursOfTheory() {
        return hoursOfTheory;
    }

    public void setHoursOfTheory(int hoursOfTheory) {
        this.hoursOfTheory = hoursOfTheory;
    }

    public int getHoursOfPractice() {
        return hoursOfPractice;
    }

    public void setHoursOfPractice(int hoursOfPractice) {
        this.hoursOfPractice = hoursOfPractice;
    }
}
