package com.sbu.Ecom.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    @Id
    private int orderItemId;

    //One Product can have many OrderItems
    @ManyToOne
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    //one order can have many Orderitems
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

}
