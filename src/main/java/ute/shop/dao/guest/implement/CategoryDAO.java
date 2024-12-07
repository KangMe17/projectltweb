package ute.shop.dao.guest.implement;

import jakarta.persistence.EntityManager;
import ute.shop.entity.Category;

import java.util.List;

public class CategoryDAO {
    private final EntityManager em;

    public CategoryDAO(EntityManager em) {
        this.em = em;
    }

    // Phương thức tìm tất cả danh mục
    public List<Category> findAll() {
        return em.createQuery("SELECT c FROM Category c WHERE c.isDeleted = false", Category.class)
                 .getResultList();
    }
}
