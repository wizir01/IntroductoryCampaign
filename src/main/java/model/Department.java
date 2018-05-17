package model;

import java.util.Objects;

public class Department {
    private int id;
    private int specialityId;
    private int universityId;
    private int studyPlacesNumber;

    public Department() {
    }

    public Department(int id, int specialityId, int universityId, int studyPlacesNumber) {
        this.id = id;
        this.specialityId = specialityId;
        this.universityId = universityId;
        this.studyPlacesNumber = studyPlacesNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public int getStudyPlacesNumber() {
        return studyPlacesNumber;
    }

    public void setStudyPlacesNumber(int studyPlacesNumber) {
        this.studyPlacesNumber = studyPlacesNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                specialityId == that.specialityId &&
                universityId == that.universityId &&
                studyPlacesNumber == that.studyPlacesNumber;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, specialityId, universityId, studyPlacesNumber);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", specialityId=" + specialityId +
                ", universityId=" + universityId +
                ", studyPlacesNumber=" + studyPlacesNumber +
                '}';
    }
}
