package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.services.CheckoutService;
import com.example.demo.services.Purchase;
import com.example.demo.services.PurchaseResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Customer customer = purchase.getCustomer();
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        String trackingNumber = generateTrackingNumber();
        cart.setOrderTrackingNumber(trackingNumber);

        cart.setStatus(StatusType.ordered);

        customer.add(cart);

        for (CartItem item : cartItems) {
            cart.add(item);
        }

        cartRepository.save(cart);

        return new PurchaseResponse(trackingNumber);
    }
    private String generateTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
