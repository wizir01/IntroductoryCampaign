package model;

import java.util.Objects;

public class ExamsExtra {
    private int id;
    private String subjectName;
    private String userName;
    private int mark;

    public ExamsExtra() {
    }

    public ExamsExtra(int id, String subjectName, String userName, int mark) {
        this.id = id;
        this.subjectName = subjectName;
        this.userName = userName;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        ExamsExtra that = (ExamsExtra) o;
        return id == that.id &&
                mark == that.mark &&
                Objects.equals(subjectName, that.subjectName) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, subjectName, userName, mark);
    }

    @Override
    public String toString() {
        return "ExamsExtra{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", userName='" + userName + '\'' +
                ", mark=" + mark +
                '}';
    }
}
