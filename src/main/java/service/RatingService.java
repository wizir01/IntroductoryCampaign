package service;

import dao.DaoRating;
import factory.DaoFactory;
import model.Rating;

public class RatingService implements IService {
    DaoRating daoRating = DaoFactory.getInstance().getDaoRating();

    public void create(Rating rating) {
        daoRating.create(rating);
    }
}
