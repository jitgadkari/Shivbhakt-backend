package com.shivbhakt.shivbhakt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "About")
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer aboutId;
    private String title;
    private String  description;
    private String  coverImage;

}
