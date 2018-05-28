package model;

import java.util.Objects;

public class Rating {
    private int id;
    private int userId;
    private int departmentId;
    private int rating;

    public Rating() {
    }

    public Rating(int userId, int departmentId, int rating) {
        this.userId = userId;
        this.departmentId = departmentId;
        this.rating = rating;
    }

    public Rating(int id, int userId, int departmentId, int rating) {
        this.id = id;
        this.userId = userId;
        this.departmentId = departmentId;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return id == rating1.id &&
                userId == rating1.userId &&
                departmentId == rating1.departmentId &&
                rating == rating1.rating;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, departmentId, rating);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", userId=" + userId +
                ", departmentId=" + departmentId +
                ", rating=" + rating +
                '}';
    }
}
