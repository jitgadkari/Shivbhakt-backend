package com.shivbhakt.shivbhakt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MyOrder")
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer myOrderId;
    private Integer orderId;
    private Integer amount;
    private String currency;
    private String receipt;
    private  String status;
    private  Integer attempts;
    private  String paymentId;

}
