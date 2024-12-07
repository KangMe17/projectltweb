package ute.shop.dao.guest.implement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import ute.shop.entity.User;

public class UserDAO {
	private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    public void saveUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User findUserByEmail(String email) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                     .setParameter("email", email)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public User findUserByPhone(String phone) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.phone = :phone", User.class)
                     .setParameter("phone", phone)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
