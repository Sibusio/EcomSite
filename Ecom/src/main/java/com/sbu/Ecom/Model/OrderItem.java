package com.sbu.Ecom.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    private int orderItemId;

    //One Product can have many OrderItems
    @ManyToOne
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    //one order can have many Orderitems
    @ManyToOne
    private Order order;

}
