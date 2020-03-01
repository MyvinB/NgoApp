package com.cts.ordering.service;

import com.cts.ordering.model.Receipt;
import com.cts.ordering.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 @author Myvin Barboza
 01/03/20 1:51 AM 
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public boolean saveOrder(String id, String ngo, String restaurant) {

        Receipt order=new Receipt();
        order.setId(id);
        order.setNgo(ngo);
        order.setRestaurant(restaurant);
        orderRepository.save(order);
        return true;
    }
}