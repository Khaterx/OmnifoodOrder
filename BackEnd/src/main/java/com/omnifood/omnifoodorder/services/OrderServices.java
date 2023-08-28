package com.omnifood.omnifoodorder.services;

import com.omnifood.omnifoodorder.deo.OrderRepository;
import com.omnifood.omnifoodorder.model.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findAll(pageable).getContent();
    }

    public List<Order> getOrdersByCategoryId(Long id,int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findByCategoryId(id,pageable).getContent();
    }

    public List<Order> getOrderByName(String name,int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findByNameContaining(name,pageable).getContent();
    }

    public Order getOrderById(long id) {
        return orderRepository.findById(id).get();
    }

    public long getOrderLength(){
        return orderRepository.count();
    }

    public long getOrderLengthByCategoryId(long id){
        return orderRepository.getOrderLengthByCategoryId(id);
    }

    public long getOrderLengthByKeyword(String keyword){
        return orderRepository.getOrderLengthByKeyword(keyword);
    }

}
