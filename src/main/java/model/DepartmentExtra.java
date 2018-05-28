package model;

import java.util.Objects;

public class DepartmentExtra {
    private int id;
    private String name;
    private int places;

    public DepartmentExtra() {
    }

    public DepartmentExtra(int id, String name, int places) {
        this.id = id;
        this.name = name;
        this.places = places;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentExtra that = (DepartmentExtra) o;
        return id == that.id &&
                places == that.places &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, places);
    }

    @Override
    public String toString() {
        return "DepartmentExtra{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", places=" + places +
                '}';
    }
}
