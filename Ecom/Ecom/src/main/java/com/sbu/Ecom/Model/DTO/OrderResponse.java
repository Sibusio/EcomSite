package com.sbu.Ecom.Model.DTO;

import java.time.LocalDate;
import java.util.List;

//what we send back to the customer after their order
public record OrderResponse(
        String orderId,
        String customerName,
        String email,
        String status,
        LocalDate orderDate,
        List<OrderItemResponse> items) {
}
