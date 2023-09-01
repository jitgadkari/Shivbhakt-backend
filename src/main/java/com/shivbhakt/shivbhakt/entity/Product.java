package com.shivbhakt.shivbhakt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private  String title;
    private String caption;
    private String image;
    private Integer view;
    @ManyToOne
    @JoinColumn( name = "category")
    private  Category category;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Comment> comment;

}
