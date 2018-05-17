package model;

import java.util.Objects;

public class Exams {
    private int id;
    private int subjectId;
    private int userId;
    private int mark;

    public Exams() {
    }

//    public Exams(int subjectId, int userId, int mark) {
//        this.subjectId = subjectId;
//        this.userId = userId;
//        this.mark = mark;
//    }

    public Exams(int id, int subjectId, int userId, int mark) {
        this.id = id;
        this.subjectId = subjectId;
        this.userId = userId;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exams exams = (Exams) o;
        return id == exams.id &&
                subjectId == exams.subjectId &&
                userId == exams.userId &&
                mark == exams.mark;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, subjectId, userId, mark);
    }

    @Override
    public String toString() {
        return "Exams{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", userId=" + userId +
                ", mark=" + mark +
                '}';
    }
}
