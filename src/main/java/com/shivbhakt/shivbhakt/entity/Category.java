package com.shivbhakt.shivbhakt.entity;

//import jakarta.persistence.
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer categoryId;
    private  String title;
    private  String catDescription;

    @OneToMany(mappedBy = "category",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> products =new ArrayList<>();
}
