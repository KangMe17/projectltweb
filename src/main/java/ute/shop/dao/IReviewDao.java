package ute.shop.dao;

import ute.shop.entity.Review;
import java.util.List;

public interface IReviewDao {
    Review save(Review review);
    Review update(Review review);
    void delete(int reviewId);
    Review findById(int reviewId);
    List<Review> findByProductId(int productId);
    List<Review> findByUserId(int userId);
}
