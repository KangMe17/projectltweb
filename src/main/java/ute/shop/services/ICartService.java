package ute.shop.services;

import ute.shop.entity.Cart;
import ute.shop.entity.User;

public interface ICartService {
    Cart findCartByUserId(int userId);
    Cart getCartByUser(User user);
    Cart createCart(User user);
    Cart addOrUpdateCartItem(int cartId, int productId, int quantity);
    void removeCartItem(int cartId, int productId);
}