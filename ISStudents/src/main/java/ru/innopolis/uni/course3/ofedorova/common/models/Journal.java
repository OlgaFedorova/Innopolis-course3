package ru.innopolis.uni.course3.ofedorova.common.models;

/**
 * Created by Olga on 22.12.2016.
 */
public class Journal extends Base {

    private String dateOfRecord;
    private Lecture lecture;
    private Student student;

    public Journal(int id, String dateOfRecord, Lecture lecture, Student student) {
        super(id);
        this.dateOfRecord = dateOfRecord;
        this.lecture = lecture;
        this.student = student;
    }

    public String getDateOfRecord() {
        return dateOfRecord;
    }

    public void setDateOfRecord(String dateOfRecord) {
        this.dateOfRecord = dateOfRecord;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
