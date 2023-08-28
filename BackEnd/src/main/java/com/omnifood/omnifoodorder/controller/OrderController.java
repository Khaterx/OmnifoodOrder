package com.omnifood.omnifoodorder.controller;

import com.omnifood.omnifoodorder.model.Order;
import com.omnifood.omnifoodorder.services.OrderServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/v1/api")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @GetMapping("/getAllOrder")
    public List<Order> getAllOrder(@RequestParam int page,@RequestParam int size) {
        return orderServices.getAllOrder(page,size);
    }
    //    http://127.0.0.1:8080/v1/api/getOrderByCategoriesId?id={value} @RequestParam
    //    http://127.0.0.1:8080/v1/api/getOrderByCategoriesId/{value}  @PathVariable
    @GetMapping("/getOrderByCategoryId")
    public List<Order> getAllOrderByCategoryId(@RequestParam Long id,@RequestParam int page,@RequestParam int size) {
        return orderServices.getOrdersByCategoryId(id,page,size);
    }

    @GetMapping("/getOrderByName/{name}&{page}&{size}")
    public List<Order> getOrderByName(@PathVariable String name,@PathVariable int page,@PathVariable int size) {
        return orderServices.getOrderByName(name,page,size);
    }

    @GetMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable long id) {
        return orderServices.getOrderById(id);
    }

    @GetMapping("/getOrderLength")
    public long getOrderLength(){
        return orderServices.getOrderLength();
    }

    @GetMapping("/getOrderLengthByCategoryId")
    public long getOrderLengthByCategoryId(@RequestParam long id){
        return orderServices.getOrderLengthByCategoryId(id);
    }

    @GetMapping("/getOrderLengthByKeyword")
    public long getOrderLengthByKeyword(@RequestParam String keyword){
        return orderServices.getOrderLengthByKeyword(keyword);
    }
}
