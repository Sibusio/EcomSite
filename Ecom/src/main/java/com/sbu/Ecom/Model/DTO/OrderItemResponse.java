package com.sbu.Ecom.Model.DTO;

import java.math.BigDecimal;

//Send items to user
public record OrderItemResponse(String productName, int quantity, BigDecimal totalPrice) {
}
