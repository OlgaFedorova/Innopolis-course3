package ru.innopolis.uni.course3.ofedorova.common.models;

/**
 * Created by Olga on 22.12.2016.
 */
public class Journal extends Base {

    private String dateOfRecord;
    private int idLecture;
    private int idStudent;
    private Student student;
    private Lecture lecture;

    public Journal() {
        super(1);
    }

    public Journal(int id, String dateOfRecord, int lecture, int student) {
        super(id);
        this.dateOfRecord = dateOfRecord;
        this.idLecture = lecture;
        this.idStudent = student;
    }

    public Journal(int id, String dateOfRecord, Lecture lecture, Student student) {
        super(id);
        this.dateOfRecord = dateOfRecord;
        this.student = student;
        this.lecture = lecture;
    }

    public String getDateOfRecord() {
        return dateOfRecord;
    }

    public void setDateOfRecord(String dateOfRecord) {
        this.dateOfRecord = dateOfRecord;
    }

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
