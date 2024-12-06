package ute.shop.services.implement;

import ute.shop.dao.IReviewDao;
import ute.shop.dao.implement.ReviewDaoImpl;
import ute.shop.entity.Review;
import ute.shop.services.IReviewService;

import java.util.List;

public class ReviewServiceImpl implements IReviewService {

	private final IReviewDao reviewDao = new ReviewDaoImpl();

	@Override
	public Review addReview(Review review) {
		return reviewDao.save(review);
	}

	@Override
	public Review updateReview(Review review) {
		return reviewDao.update(review);
	}

	@Override
	public void deleteReview(int reviewId) {
		reviewDao.delete(reviewId);
	}

	@Override
	public List<Review> getReviewsByProductId(int productId) {
		return reviewDao.findByProductId(productId);
	}

	@Override
	public List<Review> getReviewsByUserId(int userId) {
		return reviewDao.findByUserId(userId);
	}
}
