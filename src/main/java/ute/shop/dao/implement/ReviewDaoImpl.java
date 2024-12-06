package ute.shop.dao.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import ute.shop.config.JPAConfig;
import ute.shop.dao.IReviewDao;
import ute.shop.entity.Review;

import java.util.List;

public class ReviewDaoImpl implements IReviewDao {

    @Override
    public Review save(Review review) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(review);
            transaction.commit();
            return review;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public Review update(Review review) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Review updatedReview = em.merge(review);
            transaction.commit();
            return updatedReview;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(int reviewId) {
        EntityManager em = JPAConfig.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Review review = em.find(Review.class, reviewId);
            if (review != null) {
                em.remove(review);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) transaction.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Review findById(int reviewId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.find(Review.class, reviewId);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Review> findByProductId(int productId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Review r WHERE r.product._id = :productId", Review.class)
                    .setParameter("productId", productId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Review> findByUserId(int userId) {
        EntityManager em = JPAConfig.getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Review r WHERE r.user._id = :userId", Review.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
