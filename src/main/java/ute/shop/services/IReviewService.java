package ute.shop.services;

import ute.shop.entity.Review;

import java.util.List;

public interface IReviewService {
	Review addReview(Review review);

	Review updateReview(Review review);

	void deleteReview(int reviewId);

	List<Review> getReviewsByProductId(int productId);

	List<Review> getReviewsByUserId(int userId);
}
