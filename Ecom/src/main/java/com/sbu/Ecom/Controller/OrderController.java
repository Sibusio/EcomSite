package com.sbu.Ecom.Controller;

import com.sbu.Ecom.Model.DTO.OrderRequest;
import com.sbu.Ecom.Model.DTO.OrderResponse;
import com.sbu.Ecom.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse response = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse> ordersList = orderService.getAllOrderResponses();
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }
}
