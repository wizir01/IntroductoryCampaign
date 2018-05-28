package model;

import java.util.Objects;

public class MessageInfo {

    private String name;
    private String email;
    private String speciality;
    private String university;

    public MessageInfo() {
    }

    public MessageInfo(String name, String email, String speciality, String university) {
        this.name = name;
        this.email = email;
        this.speciality = speciality;
        this.university = university;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageInfo that = (MessageInfo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(speciality, that.speciality) &&
                Objects.equals(university, that.university);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, email, speciality, university);
    }

    @Override
    public String toString() {
        return "MessageInfo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", speciality='" + speciality + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}
