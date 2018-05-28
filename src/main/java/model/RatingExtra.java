package model;

import java.util.Objects;

public class RatingExtra implements Comparable<RatingExtra> {

    private int ratingId;
    private int userId;
    private int departmentId;
    private int rating;
    private String userName;
    private String userEmail;
    private String specialityName;
    private String universityName;

    public RatingExtra() {
    }

    public RatingExtra(int ratingId, int userId, int departmentId, int rating, String userName, String userEmail, String specialityName, String universityName) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.departmentId = departmentId;
        this.rating = rating;
        this.userName = userName;
        this.userEmail = userEmail;
        this.specialityName = specialityName;
        this.universityName = universityName;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingExtra that = (RatingExtra) o;
        return ratingId == that.ratingId &&
                userId == that.userId &&
                departmentId == that.departmentId &&
                rating == that.rating &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(specialityName, that.specialityName) &&
                Objects.equals(universityName, that.universityName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ratingId, userId, departmentId, rating, userName, userEmail, specialityName, universityName);
    }

    @Override
    public String toString() {
        return "RatingExtra{" +
                "ratingId=" + ratingId +
                ", userId=" + userId +
                ", departmentId=" + departmentId +
                ", rating=" + rating +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", specialityName='" + specialityName + '\'' +
                ", universityName='" + universityName + '\'' +
                '}';
    }

    @Override
    public int compareTo(RatingExtra o) {
        return Integer.compare(this.rating, o.rating);
    }
}
