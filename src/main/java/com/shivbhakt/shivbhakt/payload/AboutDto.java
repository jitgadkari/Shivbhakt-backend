package com.shivbhakt.shivbhakt.payload;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer aboutId;
    private String title;
    private String  description;
    private String  coverImage;
}
