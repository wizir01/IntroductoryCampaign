package model;

import java.util.Objects;

public class DepartmentRequirement {
    private int id;
    private int departmentId;
    private int subjectId;

    public DepartmentRequirement() {
    }

    public DepartmentRequirement(int id, int departmentId, int subjectId) {
        this.id = id;
        this.departmentId = departmentId;
        this.subjectId = subjectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentRequirement that = (DepartmentRequirement) o;
        return id == that.id &&
                departmentId == that.departmentId &&
                subjectId == that.subjectId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, departmentId, subjectId);
    }

    @Override
    public String toString() {
        return "DepartmentRequirement{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", subjectId=" + subjectId +
                '}';
    }
}
