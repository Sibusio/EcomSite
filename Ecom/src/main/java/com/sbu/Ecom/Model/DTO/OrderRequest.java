package com.sbu.Ecom.Model.DTO;

import java.util.List;

//what user provides when they send sever request
public record OrderRequest(String customerName, String email, List<OrderItemRequest> items) {
}
